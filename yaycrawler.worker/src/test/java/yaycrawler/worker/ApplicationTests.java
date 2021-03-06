package yaycrawler.worker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.Scheduler;
import yaycrawler.dao.service.PageParserRuleService;
import yaycrawler.spider.pipeline.GenericPipeline;
import yaycrawler.spider.processor.GenericPageProcessor;
import yaycrawler.spider.service.PageSiteService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private GenericPipeline genericPipeline;

	@Autowired
	private PageParserRuleService parserRuleService;
	@Autowired
	private PageSiteService pageSiteService;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void testMongoDB()
	{
		Map<String, Object> data = new HashMap<>();
		data.put("name", "zhangsan");
		data.put("age", 28);
		mongoTemplate.save(data, "yay");
	}


	@Test
	public void testSpider()
	{
//		String seedUrl = "http://floor.0731fdc.com/jggs.php";
//		GenericPageProcessor pageProcessor = new GenericPageProcessor();
//
//		Downloader downloader = new HttpClientDownloader();
//		Scheduler scheduler =new QueueScheduler();
//
//		Site site = pageSiteService.getSite("floor.0731fdc.com");
	}

	@Test
	public void testFile() {
		final String path = "d:/";
		File dst = new File("dataTmp");
		if(dst != null && dst.isDirectory()) {
			File[] dstfiles = dst.listFiles();
			if(dstfiles!= null && dstfiles.length == 0) {
				for (File file :dstfiles) {
					if(file.isDirectory()) {
						File[] files = file.listFiles();
						if(files != null && files.length > 20) {
							System.out.println(file.getName());
						}
					}
				}
			}
		}

	}

}
