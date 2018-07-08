/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：UacMenuMainController.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.paascloud.provider.model.service.hystrix;

import com.paascloud.provider.model.dto.menu.*;
import com.paascloud.provider.model.dto.user.AuthUserDTO;
import com.paascloud.provider.model.dto.user.HandlerLoginDTO;
import com.paascloud.provider.model.service.UacAuthUserFeignApi;
import com.paascloud.provider.model.service.UacMenuFeignApi;
import com.paascloud.provider.model.vo.menu.MenuVo;
import com.paascloud.provider.model.vo.menu.ViewMenuVo;
import com.paascloud.wrapper.Wrapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 菜单主页面.
 *
 * @author paascloud.net @gmail.com
 */
@Component
public class UacMenuFeignApiHystrix implements UacMenuFeignApi {

	@Override
	public Wrapper<List<MenuVo>> queryMenuTreeList() {
		return null;
	}

	@Override
	public Wrapper<ViewMenuVo> queryMenuVoById(Long id) {
		return null;
	}

	@Override
	public Wrapper updateUacMenuStatusById(UacMenuStatusDto uacMenuStatusDto) {
		return null;
	}

	@Override
	public Wrapper saveMenu(UacEditMenuDto uacMenuAddDto) {
		return null;
	}

	@Override
	public Wrapper<Integer> deleteUacMenuById(Long id) {
		return null;
	}

	@Override
	public Wrapper<Boolean> checkUacMenuActionCode(UacMenuCheckCodeDto uacMenuCheckCodeDto) {
		return null;
	}

	@Override
	public Wrapper<Boolean> checkUacMenuName(UacMenuCheckNameDto uacMenuCheckNameDto) {
		return null;
	}

	@Override
	public Wrapper<Boolean> checkUacMenuUrl(UacMenuCheckUrlDto uacMenuCheckUrlDto) {
		return null;
	}
}