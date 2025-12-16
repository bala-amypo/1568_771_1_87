public interface UserService{
    public User registerUser(User user);
    public User getUser(long id);
    public List<User> getAllUsers();
    
}