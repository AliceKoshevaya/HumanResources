package db.dao;

import db.entity.Post;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public interface PostDao {
    /**
     * Select all position
     *
     * @return {@link Collection <Post>}
     */
    Collection<Post> findAllPost();

    /**
     * Select position by job code
     *
     * @param code
     * @return {@link Post}
     */
    Post getPostByCode(int code);
}
