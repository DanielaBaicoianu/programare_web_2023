package com.lab6.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lab6.dto.UserDto;
import com.lab6.entity.User;
import com.lab6.entity.UserDetails;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByUsername(String username){

        String getUserQuery = "SELECT * FROM laborator6_db.users WHERE laborator6_db.users.username = ?";

        RowMapper<User> mappingSchema = (resultSet, rowNo) -> User.builder()
                .id(resultSet.getLong("id"))
                .username(resultSet.getString("username"))
                .fullName(resultSet.getString("full_name"))
                .userType(resultSet.getString("user_type"))
                .build();
        return jdbcTemplate.query(getUserQuery, mappingSchema, username).get(0);
    }

    public void createUser(User user){

        String addUserQuery = "INSERT INTO laborator6_db.users(username, full_name, user_type) VALUE (?, ? ,?)";
        jdbcTemplate.update(addUserQuery, user.getUsername(), user.getFullName(), user.getUserType());
        Long id = getUserByUsername(user.getUsername()).getId();
        if(user.getUserDetails() != null){
            addUserQuery = "INSERT INTO laborator6_db.user_details(user_id, cnp, age, other_information) VALUE (?, ? ,?, ?)";
            jdbcTemplate.update(addUserQuery, id ,user.getUserDetails().getCnp(), user.getUserDetails().getAge(), user.getUserDetails().getOtherInformation());
        }
    }

    public List<User> getAllUsers(){
        String getAllUsersQuery = "SELECT laborator6_db.users.*, laborator6_db.user_details.* FROM laborator6_db.users " +
                "JOIN laborator6_db.user_details ON laborator6_db.user_details.user_id = laborator6_db.users.id " +
                "ORDER by laborator6_db.user_details.user_id" ;

        RowMapper<User> userRowMapper = (resultSet , rowNo) -> User.builder()
                .username(resultSet.getString("username"))
                .fullName(resultSet.getString("full_name"))
                .id(resultSet.getLong("id"))
                .userType(resultSet.getString("user_type"))
                .userDetails(UserDetails.builder()
                        .age(resultSet.getInt("age"))
                        .cnp(resultSet.getString("cnp"))
                        .userId(resultSet.getLong("user_id"))
                        .otherInformation(resultSet.getString("other_information"))
                        .build())

                .build();

        return jdbcTemplate.query(getAllUsersQuery, userRowMapper);

    }

}
