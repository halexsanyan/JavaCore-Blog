package blog.storage;


import blog.exception.PostNotFoundException;
import blog.model.Post;

public class PostStorageImpl implements PostStorage {
    private Post[] posts;
    private int size;

    public PostStorageImpl() {
        this.posts = new Post[15];
    }

    @Override
    public void add(Post post) {
        if (size == posts.length) {
            extend();
        } else {
            posts[size++] = post;
        }
    }

    private void extend() {
        Post[] temp = new Post[posts.length * 2];
        System.arraycopy(posts, 0, temp, 0, posts.length);
        posts = temp;
    }

    @Override
    public Post getPostByTitle(String title) throws PostNotFoundException {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equals(title)) {
                return posts[i];
            }
        }
        throw new PostNotFoundException("There is not that title");
    }



    @Override
    public Post searchPostsByKeyword(String keyword) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().contains(keyword) || posts[i].getText().contains(keyword)) {
                return posts[i];
            }
        }return null;
    }

    @Override
    public void printAllPosts() {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);
        }
    }

    @Override
    public Post printPostsByCategory(String category) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getCategory().equals(category)) {
                return  posts[i];
            }
        }return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
