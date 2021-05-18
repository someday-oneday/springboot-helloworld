package com.example.mybatisexamples.example06;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisexamples.entity.GithubUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
 @Repository
 @Mapper
public interface GithubUserMapper06 extends BaseMapper<GithubUser> {
  default List<GithubUser> listByOptionals(QueryOptional optionals) {
   LambdaQueryWrapper<GithubUser> qw = new QueryWrapper<GithubUser>().lambda();
   if (optionals.getStars() != null) {
    qw.ge(GithubUser::getStars, optionals.getStars());
   }
   if (optionals.getFollowers() != null) {
    qw.ge(GithubUser::getFollowers, optionals.getFollowers());
   }
   if (optionals.getRepos() != null) {
    qw.ge(GithubUser::getRepos, optionals.getRepos());
   }
   if (optionals.getBeforeCreateTime() != null) {
    qw.lt(GithubUser::getCreateTime, optionals.getBeforeCreateTime());
   }
   qw.eq(optionals.getGender() != null,
           GithubUser::getGender,
           optionals.getGender());
   return selectList(qw);
  }

  List<GithubUser> listByOptionals2(QueryOptional optionals);
 }