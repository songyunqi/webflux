/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring5.base.rep;

import com.spring5.base.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yang
 */
@Repository
public interface UserRep extends ReactiveCrudRepository<User,Long> {

}
