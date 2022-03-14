package groot.workflow.constants;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/6/2
 */
public class Constants {

    public static final int PAGE_SIZE = 10;


    public class BeansConstans {
        public static final int DELETED = 0;
        public static final int ENABLED = 1;
        public static final int DISABLED = 2;
        public static final int WO_STATUS_AUDITING = 1;
        public static final int WO_STATUS_FINISHED = 2;
        public static final int WO_STATUS_BACKED = 3;
        public static final int WF_INSTANCE_STATUS_DOING = 0;
        public static final int WF_INSTANCE_STATUS_FINISH = 1;
        public static final int WF_INSTANCE_STATUS_FAIL = 4;
    }

    public class WorkflowConstans {
        public static final String NODE = "NODE";
        public static final String WORK_FLOW = "FLOW";
        public static final String HEAD_NODE = "HEAD";
        public static final String TAIL_NODE = "TAIL";
        public static final int NO_GEN_WORKORDER_STATUS = 1;
        public static final int AUTO_CHECK = 1;
        public static final String WF_CODE_PREFIX = "F";
        public static final String NODE_CODE_PREFIX = "N";
        public static final String WF_INSTANCE_CODE_PREFIX = "I";
        public static final String WF_INSTANCE_REDIS_KEY_PREFIX = "INSTANCE_";
        public static final String WF_ORDER_CODE_PREFIX = "O";
    }

}
