package com.example.databasestud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    // Adding new entries
    public void addStudent(Stud student) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into students(name,surname,group,age,subject) values (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getSurname());
        preparedStatement.setString(3, student.getGroup());
        preparedStatement.setInt(4, student.getAge());
        preparedStatement.setString(5, student.getSubject());
        preparedStatement.executeUpdate();
    }

    // Get list of entries
    public List<Stud> getAllStudents() throws SQLException {
        List<Stud> students = new ArrayList<Stud>();
        ResultSet resultSet = connection.prepareStatement("select * from students").executeQuery();
        while (resultSet.next()) {
            Stud student = new Stud(resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getString("surname"), resultSet.getString("group"), resultSet.getInt("age"),
                    resultSet.getString("subject"));
            students.add(student);
        }
        return students;
    }

    // Updating DB entry
    public void updateStudent(Stud student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update students set name=?, surname=?, group=?, age=?, subject=? where id=?");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getSurname());
        preparedStatement.setString(3, student.getGroup());
        preparedStatement.setInt(4, student.getAge());
        preparedStatement.setString(5, student.getSubject());
        preparedStatement.setInt(6, student.getId());
        preparedStatement.executeUpdate();
    }

    // Deleting entries
    public void deleteStudent(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
