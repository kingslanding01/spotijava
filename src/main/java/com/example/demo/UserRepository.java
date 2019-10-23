package com.example.demo;
import org.apache.tomcat.jni.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long> {
}
