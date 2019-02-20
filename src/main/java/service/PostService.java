package service;

import db.entity.Post;

import java.util.Collection;

public interface PostService {
    public Collection<Post> findAllPost();
}
