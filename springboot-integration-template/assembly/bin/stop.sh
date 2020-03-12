#!/bin/bash

## 应用名称需要修改
APP_NAME=app-one

## 先尝试kill,再尝试kill -9
ps -ef|grep $APP_NAME |grep -v grep|awk '{print $2}'|xargs kill
sleep 3
ps -ef|grep $APP_NAME |grep -v grep|awk '{print $2}'|xargs kill -9