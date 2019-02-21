package service.impl;

import db.dao.PostDao;
import db.dao.impl.PostDaoImpl;
import db.dao.util.ConnectionManager;
import db.entity.Post;
import service.PostService;

import java.sql.Connection;
import java.util.Collection;

public class PostServiceImpl implements PostService {

    private PostDao postDao = PostDaoImpl.getInstance();

    public Collection<Post> findAllPost(){
        return postDao.findAllPost();

    }

    @Override
    public Post getPostByCode(int code) {
        return postDao.getPostByCode(code);
    }
}
