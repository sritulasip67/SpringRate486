package com.example.repository;

import com.example.entity.RateResponseEntity;
 import java.util.ArrayList;
  import java.util.List;

     public class RateResponseRepository { private List<RateResponseEntity> db = new ArrayList<>(); private long idCounter = 1;

        public RateResponseEntity save(RateResponseEntity entity) {
            entity.id = idCounter++;
            db.add(entity);
            return entity;
        }
        
        public List<RateResponseEntity> findAll() {
            return db;
        }
        
        }