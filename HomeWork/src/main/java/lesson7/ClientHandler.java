package lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Обслуживает клиента(отвечает за связь между клиентом и сервером)
 */
public class ClientHandler {

    private MyServer server;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer server, Socket socket) {
       try{
           this.server = server;
           this.socket = socket;
           this.inputStream = new DataInputStream(socket.getInputStream());
           this.outputStream = new DataOutputStream(socket.getOutputStream());
           this.name = "";
           new Thread(() -> {
               try {
               authentification();
               readMessages();
           } catch (IOException e){
                   e.printStackTrace();
           } finally {
                   closeConnection();
               }
           }).start();
       } catch (IOException ex){
           System.out.println("Проблема при создании клиента");
       }

    }

    private void readMessages() throws IOException {
        while (true){
            String messageFromClient = inputStream.readUTF();
            System.out.println("от " + name + ": " + messageFromClient);
            if (messageFromClient.equals(ChatConstants.STOP_WORD)) {
                return;
            } else if(messageFromClient.startsWith(ChatConstants.SEND_TO_NICK)){
                String[] splitedStr = messageFromClient.split("\\s+");
                List<String> nicknames = new ArrayList<>();
                for (int i = 1; i < splitedStr.length - 1; i++){
                    nicknames.add(splitedStr[i]);
                    server.broadcastMessageToClient(this, "[" + name + "]: " + messageFromClient, nicknames); // "[" + name + "]: " + messageFromClient
                }
            } else if(messageFromClient.startsWith(ChatConstants.CLIENTS_LIST)){
                server.broadcastClients();
            } else {
                server.broadcastMessage("[" + name + "]: " + messageFromClient); // клиент пишет сообщение, отправляя его на сервер. Сервер отправляет сообщение другим клиентам через socket.
            }
        }
    }

    // /auth login pass сюда время ожидания авторизации
    private void authentification() throws IOException {
        while (true){
            String message = inputStream.readUTF();
            if(message.startsWith(ChatConstants.AUTH_COMMAND)){
               String[] parts = message.split("\\s+"); // разбиваем строчку по пробелам длинной 3 (регулярное выражение)
               String nick = server.getAuthService().getNickByLoginAndPass(parts[1], parts[2]);
               if(nick != null) {
                   // проверка уникальности ника
                   if (!server.isNickBusy(nick)){
                       sendMsg(ChatConstants.AUTH_OK + " " + nick);
                       name = nick;
                       server.subscribe(this); // подписка клиента на сервер, чтобы сервер мог отправлять сообщения клиенту
                       server.broadcastMessage(name + " вошел в чат");
                       return;
                   } else {
                       sendMsg("Ник уже используется");
                   }
               } else {
                sendMsg("Неверные логин/пароль");
               }
            }
        }
    }

    public void sendMsg(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        server.unsubscribe(this);
        server.broadcastMessage(name + " вышел из чата");
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
