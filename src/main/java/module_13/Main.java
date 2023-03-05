package module_13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static module_13.HttpUtil.*;

public class Main {
    private static final String URL_USERS = "https://jsonplaceholder.typicode.com/users";
    private static final String URL_POSTS = "https://jsonplaceholder.typicode.com/posts";

    public static void main(String[] args) {

//        Завдання №1.
//        *-   створення нового об'єкта в https://jsonplaceholder.typicode.com/users
//        *-   оновлення об'єкту в https://jsonplaceholder.typicode.com/users
//        *-   видалення об'єкта з https://jsonplaceholder.typicode.com/users
//        *   отримання інформації про всіх користувачів https://jsonplaceholder.typicode.com/users
//        *-   отримання інформації про користувача за id https://jsonplaceholder.typicode.com/users/{id}
//        *-   отримання інформації про користувача за username - https://jsonplaceholder.typicode.com/users?username={username}
        System.out.println("**********************************************   Завдання №1    **********************************************");

        //   Отримання інформації про користувача за id
        int userId = 3;
        System.out.println("Отримання інформації про користувача за id №" + userId+ "\n");
        User selectUser= HttpUtil.readUserId(URL_USERS, userId);
        System.out.println("selectUser = " + selectUser);

        //   оновлення об'єкту
        String newName = "Oleksandr Rohan";
        System.out.println("\nОновлення об'єкту id №" + selectUser.getId() + " поля getName() " + "\"" +selectUser.getName() + "\" на " + "\"" + newName + "\"" + "\n");
        selectUser.setName(newName);
        System.out.println(HttpUtil.updateUser(URL_USERS, selectUser));

        //   створення нового об'єкта
        System.out.println("\nСтворення нового об'єкта \n");
        System.out.println(createUser(URL_USERS, createDefaultUser()));

        //   видалення об'єкта
        userId = 4;
        System.out.println("\nВидалення об'єкта №" + userId + " = " + HttpUtil.deleteUser(URL_USERS, userId));

        //   отримання інформації про користувача за username
        String userName = "Kamren";
        System.out.println("\nОтримання інформації про користувача за username = " + "\"" + userName + "\"" + "\n");
        System.out.println(readUserName(URL_USERS, "Kamren"));

        //   отримання інформації про всіх користувачів
        System.out.println("\nОтримання інформації про всіх користувачів\n");
        System.out.println(readAllUser(URL_USERS));

//        Завдання №2.
//        Доповніть програму методом, що буде виводити всі коментарі до останнього поста певного користувача і записувати їх у файл.
//        https://jsonplaceholder.typicode.com/users/1/posts Останнім вважаємо пост з найбільшим id.
//        https://jsonplaceholder.typicode.com/posts/10/comments
//        Файл повинен називатись user-X-post-Y-comments.json, де Х - id користувача, Y - номер посту.
        System.out.println("**********************************************   Завдання №2    **********************************************");
        userId = 6;
        int lastPost = readMaxLastPostUser(URL_USERS, userId);
        toJsonFile(userId, lastPost, readAllCommentsToLastPost(URL_POSTS, lastPost));

//        Завдання №3.
//        Доповніть програму методом, що буде виводити всі відкриті задачі для користувача з ідентифікатором X.
//        https://jsonplaceholder.typicode.com/users/1/todos.
//        Відкритими вважаються всі задачі, у яких completed = false.
        System.out.println("**********************************************   Завдання №3    **********************************************");
        List<Todo> todos = readAllFreeTasksUser(URL_USERS, 3);
        System.out.println("todos = " + todos);
    }
    private static User createDefaultUser() {
        User user1 = new User();
        user1.setId(12);
        user1.setName("Alex Smit");
        user1.setEmail("AlexSmit@gmail.com");
        user1.setAddress(new Address("ulas Light", "Apt. 556", "Gwenborough", "92998-3874", new Geo("-37.3159", "81.1496")));
        user1.setPhone("1-770-736-8031 x56442");
        user1.setWebsite("hildegard.org");
        user1.setCompany(new Company("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets"));
        return user1;
    }

    public static void toJsonFile(int userId, int lastPost, List<String> commentsList) {
        String fileName = "user-" + userId + "-post-" + lastPost + "-comments.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fileWriter = new FileWriter("src/main/resources/" + fileName)) {
            gson.toJson(commentsList, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
