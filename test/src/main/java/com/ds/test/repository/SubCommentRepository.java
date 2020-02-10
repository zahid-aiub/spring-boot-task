package com.ds.test.repository;

import com.ds.test.entity.SubComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCommentRepository  extends JpaRepository<SubComment, Long> {

}
