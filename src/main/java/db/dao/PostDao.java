package db.dao;

import db.entity.Post;

import java.sql.Connection;
import java.util.Collection;

public interface PostDao {
    public Collection<Post> findAllPost();
    Post getPostByCode(int code);
}
