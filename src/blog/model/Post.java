package blog.model;


import java.util.Date;

public class Post {
    private String title;
    private String text;
    private PostCategory category;
    private User user;
    private Date createdDate;
   // private SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    public Post(String title, String text, PostCategory category, User user, Date createdDate) {
        this.title = title;
        this.text = text;
        this.category = category;
        this.user = user;
        this.createdDate = createdDate;
    }

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PostCategory getCategory() {
        return category;
    }

    public void setCategory(PostCategory category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (text != null ? !text.equals(post.text) : post.text != null) return false;
        if (category != null ? !category.equals(post.category) : post.category != null) return false;
        if (user != null ? !user.equals(post.user) : post.user != null) return false;
        return createdDate != null ? createdDate.equals(post.createdDate) : post.createdDate == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", user=" + user.getName()+" " + user.getSurname()+
                ", createdDate=" + createdDate +
                '}';
    }

}
