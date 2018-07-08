/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：UacActionMainController.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.paascloud.operate.controller;

import com.paascloud.base.dto.CheckValidDto;
import com.paascloud.core.support.BaseController;
import com.paascloud.provider.model.dto.log.OperationLogDto;
import com.paascloud.provider.model.dto.user.AuthUserDTO;
import com.paascloud.provider.model.dto.user.HandlerLoginDTO;
import com.paascloud.provider.model.dto.user.ResetLoginPwdDto;
import com.paascloud.provider.model.dto.user.UserRegisterDto;
import com.paascloud.provider.model.service.UacAuthUserFeignApi;
import com.paascloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * The class Uac action main controller.
 *
 * @author paascloud.net @gmail.com
 */
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Web - UacAuthUserController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UacAuthUserController extends BaseController implements UacAuthUserFeignApi {


	@Resource
	private UacAuthUserFeignApi uacAuthUserFeignApi;


	/**
	 * 校验手机号码.
	 *
	 * @param mobileNo the mobile no
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/checkPhoneActive/{mobileNo}")
	@ApiOperation(httpMethod = "POST", value = "校验手机号码")
	public Wrapper<Boolean> checkPhoneActive(String mobileNo) {
		return uacAuthUserFeignApi.checkPhoneActive(mobileNo);
	}

	/**
	 * 校验邮箱.
	 *
	 * @param email the email
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/checkEmailActive/{email:.+}")
	@ApiOperation(httpMethod = "POST", value = "校验邮箱")
	public Wrapper<Boolean> checkEmailActive(String email) {
		return uacAuthUserFeignApi.checkEmailActive(email);
	}

	/**
	 * 校验数据.
	 *
	 * @param checkValidDto the check valid dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/checkValid")
	@ApiOperation(httpMethod = "POST", value = "校验数据")
	public Wrapper checkValid(CheckValidDto checkValidDto) {
		return uacAuthUserFeignApi.checkValid(checkValidDto);
	}

	/**
	 * 重置密码-邮箱-提交.
	 *
	 * @param email the email
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/submitResetPwdEmail")
	@ApiOperation(httpMethod = "POST", value = "重置密码-邮箱-提交")
	public Wrapper<String> submitResetPwdEmail(String email) {
		logger.info("重置密码-邮箱-提交, email={}", email);
		return uacAuthUserFeignApi.submitResetPwdEmail(email);
	}


	/**
	 * 重置密码-手机-提交.
	 *
	 * @param mobile   the mobile
	 * @param response the response
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/submitResetPwdPhone")
	@ApiOperation(httpMethod = "POST", value = "重置密码-手机-提交")
	public Wrapper<String> submitResetPwdPhone(String mobile, HttpServletResponse response) {
		logger.info("重置密码-手机-提交, mobile={}", mobile);
		return uacAuthUserFeignApi.submitResetPwdPhone(mobile,response);
	}

	/**
	 * 重置密码-最终提交.
	 *
	 * @param resetLoginPwdDto the reset login pwd dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/resetLoginPwd")
	@ApiOperation(httpMethod = "POST", value = "重置密码-最终提交")
	public Wrapper<Boolean> checkResetSmsCode(ResetLoginPwdDto resetLoginPwdDto) {
		return uacAuthUserFeignApi.checkResetSmsCode(resetLoginPwdDto);
	}

	/**
	 * 注册用户.
	 *
	 * @param user the user
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/register")
	@ApiOperation(httpMethod = "POST", value = "注册用户")
	public Wrapper registerUser(UserRegisterDto user) {
		return uacAuthUserFeignApi.registerUser(user);
	}

	/**
	 * 激活用户.
	 *
	 * @param activeUserToken the active user token
	 *
	 * @return the wrapper
	 */
	@GetMapping(value = "/activeUser/{activeUserToken}")
	@ApiOperation(httpMethod = "POST", value = "激活用户")
	public Wrapper activeUser(String activeUserToken) {
		return uacAuthUserFeignApi.activeUser(activeUserToken);
	}

	/**
	 * 查询日志.
	 *
	 * @param operationLogDto the operation log dto
	 *
	 * @return the integer
	 */
	@PostMapping(value = "/saveLog")
	@ApiOperation(httpMethod = "POST", value = "查询日志")
	public Wrapper<Integer> saveLog(OperationLogDto operationLogDto) {
		logger.info("saveLog - 保存操作日志. operationLogDto={}", operationLogDto);
		return uacAuthUserFeignApi.saveLog(operationLogDto);
	}
	/**
	 * callbackQQ
	 * qq回调.
	 *
	 * @param request the operation log dto
	 *
	 * @return the integer
	 */
	@PostMapping(value = "/callback/qq")
	public Wrapper callbackQQ(HttpServletRequest request) {
		logger.info("callback - callback qq. request={}", request);
		return uacAuthUserFeignApi.callbackQQ(request);
	}
	/**
	 * Gets auth user dto.
	 *
	 * @param loginName the login name
	 *
	 * @return the auth user dto
	 */
	public Wrapper<AuthUserDTO> getAuthUserDTO(@PathVariable("loginName") String loginName) {
		return uacAuthUserFeignApi.getAuthUserDTO(loginName);
	}

	/**
	 * Handler login data.
	 *
	 * @param handlerLoginDTO the handler login dto
	 */
	public Wrapper<?> handlerLoginData(@RequestBody HandlerLoginDTO handlerLoginDTO) {
		return uacAuthUserFeignApi.handlerLoginData(handlerLoginDTO);
	}
}