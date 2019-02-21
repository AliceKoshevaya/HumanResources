package db.dao.impl;

import db.dao.util.ConnectionManager;
import db.dao.PostDao;
import db.dao.util.DatabaseRequests;
import db.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PostDaoImpl implements PostDao {
    private static volatile PostDaoImpl instance;
    private static Connection connection = ConnectionManager.getConnection();

    private PostDaoImpl() {
    }

    public static PostDaoImpl getInstance() {
        PostDaoImpl localInstance = instance;
        if (localInstance == null) {
            synchronized (PostDaoImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PostDaoImpl();
                }
            }
        }
        return localInstance;
    }

    public static void main(String[] args) {
        PostDaoImpl postDao = PostDaoImpl.getInstance();
        System.out.println(postDao.findAllPost());
        System.out.println(postDao.getPostByCode(20));
    }

    public List<Post> findAllPost() {
        List<Post> postsList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.SELECT_ALL_POST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Post post = Post.builder()
                        .id(resultSet.getLong(1))
                        .jobCode(resultSet.getInt(2))
                        .postName(resultSet.getNString(3))
                        .build();
                postsList.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postsList;
    }

    @Override
    public Post getPostByCode(int code) {
        Post post = null;
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DatabaseRequests.SELECT_POST_BY_CODE)) {
            preparedStatement.setInt(1, code);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                post = new Post();
                post.setId(resultSet.getLong(1));
                post.setJobCode(code);
                post.setPostName(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return post;
    }

}
