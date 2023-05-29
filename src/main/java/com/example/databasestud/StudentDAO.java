package com.example.databasestud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.databasestud.Student;

public class StudentDAO {
    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    // Добавление записи в БД
    public void addStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into students(name,surname,group,age,subject) values (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getSurname());
        preparedStatement.setString(3, student.getGroup());
        preparedStatement.setInt(4, student.getAge());
        preparedStatement.setString(5, student.getSubject());
        preparedStatement.executeUpdate();
    }

    // Получение списка записей из БД
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<Student>();
        ResultSet resultSet = connection.prepareStatement("select * from students").executeQuery();
        while (resultSet.next()) {
            Student student = new Student(resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getString("surname"), resultSet.getString("group"), resultSet.getInt("age"),
                    resultSet.getString("subject"));
            students.add(student);
        }
        return students;
    }

    // Обновление записи в БД
    public void updateStudent(Student student) throws SQLException {
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

    // Удаление записи из БД
    public void deleteStudent(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
