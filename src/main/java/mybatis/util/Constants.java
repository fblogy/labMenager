package mybatis.util;

public interface Constants {
	public static final Integer PROJECT_RESPONSER=4;//项目负责人
	public static final Integer MANAGER=2;//管理员
	public static final Integer SUPRE_MANAGER=1;//超级管理员
	public static final Integer GROUPER=5;//组长

	public static final String FREQUENCY_CURRENT_WEEK="0";
	public static final String FREQUENCY_PER_WEEK="1";
	public static final Integer WEEK_COUNT=4;//连续一个月

	public static final Integer SIGN_TOP_COUNT=3;//签到次数前几位

	public static final Short ACTIVITY_OVER=2;//活动已结束
	public static final Integer ACTIVITY_SUCCESS=1;//活动审核成功
	public static final Short ACTIVITY_WAITING=0;//活动待审核
	public static final Integer ACTIVITY_FAIL=-1;//活动审核失败
	public static final Integer ACTIVITY_FULL=-2;//活动报名人数已满
	public static final Integer ACTIVITY_LATE=-3;//活动报名迟到
	public static final Integer ACTIVITY_ATTENDED=-4;//已经报过名了

	public static final Integer PROJECT_ATTENDED=-4;//已经报过名了
	public static final Integer PROJECT_FULL=-2;//项目人数已满
	public static final Integer PROJECT_LATE=-1;//项目报名已截至
	public static final Integer PROJECT_NOT_START=0;
	public static final Integer PROJECT_DOING=1;//项目已经开始，正在进行中
	public static final Integer PROJECT_END=2;//项目已结束

	public static final Integer TASK_SUBMIT_LATE=-1;//作业提交迟到

	public static final Integer NO_SEAT=-1;//-1表示当前没有座位

	public static final String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";//时间格式
	public static final String FORMAT="yyyy-MM-dd";

	public static final Integer HEALTH_HEAD_MAX_SHOW=4;//卫生负责人列表显示条数

	public static final String LOGIN_PAGE="login.html";
	public static final String INDEX_PAGE="index.html";
}