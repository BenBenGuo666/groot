package groot.workflow.util;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Desc
 * @Author Guobenben
 * @Date 2021/6/6
 */
public class PageUtils {

    /**Ø
     * PageInfo<Object> pageInfo =
     *  PageUtils.page(pageNum, pageSize, () -> mapper.selectList());
     * @param pageNum
     * @param pageSize
     * @param select
     * @return
     */
    public static PageInfo page(int pageNum, int pageSize, ISelect select) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(select);
    }

}