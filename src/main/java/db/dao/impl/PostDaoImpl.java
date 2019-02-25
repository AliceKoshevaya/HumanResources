package db.dao.impl;

import db.dao.util.ConnectionManager;
import db.dao.PostDao;
import db.dao.util.DatabaseRequests;
import db.entity.Post;
import db.exception.QueryException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PostDaoImpl implements PostDao {
    private static volatile PostDaoImpl instance;
    private static Connection connection = ConnectionManager.getConnection();

    private static final String ERROR_MESSAGE_SELECT_ALL_POST = "Can't find all post";
    private static final String ERROR_MESSAGE_SELECT_POST_BY_CODE = "Can't select post by (code = %d)";

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

    public List<Post> findAllPost()  throws QueryException{
        List<Post> postsList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DatabaseRequests.SELECT_ALL_POST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Post post = Post.builder()
                        .jobCode(resultSet.getInt(1))
                        .postName(resultSet.getNString(2))
                        .salary(resultSet.getDouble(3))
                        .build();
                postsList.add(post);
            }
        } catch (SQLException e) {
            throw new QueryException(ERROR_MESSAGE_SELECT_ALL_POST, e);
        }
        return postsList;
    }

    @Override
    public Post getPostByCode(int code) throws QueryException {
        Post post = null;
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(DatabaseRequests.SELECT_POST_BY_CODE)) {
            preparedStatement.setInt(1, code);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                post = new Post();
                post.setJobCode(code);
                post.setPostName(resultSet.getString(2));
                post.setSalary(resultSet.getDouble(3));
            }
        } catch (SQLException ex) {
            throw new QueryException(String.format(ERROR_MESSAGE_SELECT_POST_BY_CODE, code), ex);
        }
        return post;
    }

}
