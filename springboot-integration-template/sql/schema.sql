SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '应用名称',
  `module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `http_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'HTTP METHOD',
  `request_uri` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求链接（不含参数）',
  `request_body` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求Body内容',
  `operator` bigint(12) NULL DEFAULT NULL COMMENT '操作人',
  `client_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端IP',
  `start_time` datetime(0) NOT NULL COMMENT '操作起始时间',
  `finish_time` datetime(0) NULL DEFAULT NULL COMMENT '操作结束时间',
  `cost` bigint(20) NULL DEFAULT NULL COMMENT '操作耗时(单位: 毫秒)',
  `is_success` bit(1) NOT NULL DEFAULT b'0' COMMENT '操作是否成功',
  `ex_msg` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '异常信息',
  `returning` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '返回值',
  `request_query_string` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求参数',
  `operator_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9181 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;