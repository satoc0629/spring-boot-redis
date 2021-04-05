package com.example.demo.repository;


import com.example.demo.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRedisRepository extends CrudRepository<Message, Long> {
}
