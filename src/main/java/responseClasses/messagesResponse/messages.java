package responseClasses.messagesResponse;

public class messages {

    public String loginMsg = "User exists!";
    public String accountCreatedMsg = "User created!";
    public String accountDeletedMsg = "Account deleted!";
    public String accountUpdatedMsg = "User updated!";
    public String loginWithInvalidDataMsg = "User not found!";
    public String invalidRequestMethod = "This request method is not supported.";
    public String searchWithOutParameter ="Bad request, search_product parameter is missing in POST request.";
    public String loginWithMissingParameter = "Bad request, email or password parameter is missing in POST request.";
}
