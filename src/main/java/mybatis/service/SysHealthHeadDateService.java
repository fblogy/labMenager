package mybatis.service;

import java.util.Date;

public interface SysHealthHeadDateService {

    /**
     * 更新上传日期
     * @param date
     * @return
     */
    boolean update(Date date);

    /**
     * 获取生产日期
     * @return
     */
    Date getDate();
}
