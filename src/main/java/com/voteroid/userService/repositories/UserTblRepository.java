package com.voteroid.userService.repositories;

import org.springframework.data.repository.CrudRepository;

import com.voteroid.userService.entities.UserTbl;
import com.voteroid.userService.entities.UserTblPrimaryKey;

public interface UserTblRepository extends CrudRepository<UserTbl,UserTblPrimaryKey> {
		public UserTbl findByUserIdAndPassword(int userId,String password);
}
