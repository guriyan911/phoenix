package com.kamos.phoenix.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kamos.phoenix.PhoenixApplication;
import com.kamos.phoenix.domain.ProjectMonth;
import com.kamos.phoenix.service.ProjectMonthService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PhoenixApplication.class)
@Transactional
@IntegrationTest("server.port:0")
public class ProjectMonthControllerTest {
	@Autowired
	private ProjectMonthService projectMonthService;
	
	// IntegrationTestならPhoenixApplication.classを@SpringApplicationConfigurationで読みこめばいい。
	// ただしそうなるとサーバが起動する形になる。
	
	
	@Test
	public void getProjectMonths() {
		// 複数の案件月別が取得できることを確認する
		List<ProjectMonth> projectMonthList = projectMonthService.findAll();
		assertThat(projectMonthList).hasSize(3);
	}
	
	@Test
	public void putProjectMonth() {
		ProjectMonth projectMonth = new ProjectMonth();
		projectMonth.setProjectId("3");
		projectMonth.setProjectName("テスト追加プロジェクト");
		projectMonth.setYm("201512");
		projectMonthService.save(projectMonth);
		List<ProjectMonth> projectMonthList = projectMonthService.findAll();
		assertThat(projectMonthList).hasSize(4);
		
	}

}
