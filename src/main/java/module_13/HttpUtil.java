package module_13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class HttpUtil {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static User readUserId(String url, int id) {
        URI uri = URI.create(url + "/" + id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), User.class);
    }

    public static User readUserName(String url, String username) {
        URI uri = URI.create(url + "?username=" + username);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<User> userList = new Gson().fromJson(response.body(), new TypeToken<List<User>>() {}.getType());
        return userList.get(0);
    }

    public static User createUser(String url, User user) {
        URI uri = URI.create(url);
        String requestBody = new Gson().toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), User.class);
    }
    public static User updateUser(String url, User user) {
        URI uri = URI.create(url + "/" + user.getId());
        String requestBody = new Gson().toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), User.class);
    }

    public static boolean deleteUser (String url, int id){
        URI uri = URI.create(url + "/" + id);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .DELETE()
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.statusCode() == 200;
    }

    public static List<User> readAllUser(String url) {
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
    }

    public static int readMaxLastPostUser(String url, int UserId){
        URI uri = URI.create(url + "/" + UserId + "/posts");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Post> postList = new Gson().fromJson(response.body(), new TypeToken<List<Post>>() {}.getType());

        Integer lastPost = postList.stream()
                .map(Post::getId)
                .max(Integer::compareTo).get();
        return lastPost;
    }

    public static List<String> readAllCommentsToLastPost(String url, int id){
        URI uri = URI.create(url + "/" + id + "/comments");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Comment> commentsList = new Gson().fromJson(response.body(), new TypeToken<List<Comment>>() {}.getType());

        return commentsList.stream()
                .map(Comment::getBody)
                .collect(Collectors.toList());
    }

    public static List<Todo> readAllFreeTasksUser(String url, int userId) {
        //URI uri = URI.create(url + "?username=" + username);
        URI uri = URI.create(url + "/" + userId + "/todos" + "?completed=" + "false");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Todo> userList = new Gson().fromJson(response.body(), new TypeToken<List<Todo>>() {}.getType());
        return userList;
    }
}
