package src.test.thread;//package cn.tang.web1.thread;
//
//import com.cybx.behaverminiapp.dao.BehaviorMiniAppDao;
//import com.cybx.behaverminiapp.model.BehaviorMiniApp;
//import com.cybx.behaverminiapp.model.BehaviorMiniAppStatistics;
//import com.cybx.behaverminiapp.service.BehaviorMiniAppService;
//import com.cybx.behaverminiapp.vo.*;
//import com.cybx.behaverminiappotherconfig.dao.BehaviorMiniOtherConfigDao;
//import com.cybx.behaverminiappotherconfig.model.BehaviorMiniAppOtherConfig;
//import com.cybx.carevaluate.dao.CarEvaluateDao;
//import com.cybx.carmainterance.dao.CarMainteranceDao;
//import com.cybx.carroadhelp.dao.CarRoadHelpDao;
//import com.cybx.couponconsumercollect.dao.CouponConsumerCollectDao;
//import com.cybx.couponconsumercollect.model.CouponConsumerCollect;
//import com.cybx.employee.dao.EmployeeDao;
//import com.cybx.employee.model.EmployeeSimpleForGrade;
//import com.cybx.system.bean.ErrorType;
//import com.cybx.system.bean.Message;
//import com.cybx.system.bean.SystemEnumType;
//import com.cybx.system.regexp.RegExpUtils;
//import com.cybx.system.string.StringUtils;
//import com.cybx.system.time.TimeUtils;
//import com.cybx.system.utils.ListUtil;
//import com.cybx.userinfodetail.dao.UserinfoDetailDao;
//import com.cybx.userinfodetail.model.UserinfoDetail;
//import com.cybx.userwechat.dao.UserWechatDao;
//import com.cybx.userwechat.model.UserWechat;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.streaming.SXSSFCell;
//import org.apache.poi.xssf.streaming.SXSSFRow;
//import org.apache.poi.xssf.streaming.SXSSFSheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.CollectionUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional(readOnly = true)
//public class BehaviorMiniAppServiceImpl implements BehaviorMiniAppService {
//
//    private static Logger logger = LogManager.getLogger(BehaviorMiniAppServiceImpl.class);
//
//
//    @Autowired
//    BehaviorMiniAppDao behaviorMiniAppDao;
//
//
//    @Autowired
//    UserWechatDao userWechatDao;
//
//
//    @Autowired
//    EmployeeDao employeeDao;
//
//
//    @Autowired
//    UserinfoDetailDao userinfoDetailDao;
//
//
//    @Autowired
//    CouponConsumerCollectDao couponConsumerCollectDao;
//
//    @Autowired
//    CarEvaluateDao carEvaluateDao;
//
//    @Autowired
//    CarMainteranceDao carMainteranceDao;
//
//    @Autowired
//    CarRoadHelpDao carRoadHelpDao;
//
//
//    @Autowired
//    BehaviorMiniOtherConfigDao otherConfigDao;
//
//    @Override
//    public Message getTodayBehaveStatistics() {
//        //获取当天所有小程序用户行为
//        List<BehaviorMiniApp> behaviorMiniAppList = behaviorMiniAppDao.getBehaviorMiniAppList(TimeUtils.getTodayStartTime());
//        TodayVO todayVO = new TodayVO();
//        //今日概况 用户
//        todayVO.setTodayUserVO(getTodayUser(behaviorMiniAppList));
//        //今日概况 其他
//        todayVO.setTodayOther(getTodayOtherVO(behaviorMiniAppList));
//        Map<String, Object> resultMap = new HashMap<>();
//        resultMap.put("data", todayVO);
//        return new Message("获取小程序今日用户行为分析", ErrorType.SUCCESS, resultMap);
//    }
//
//
//    @Override
//    public Message getTodayCouponTrackStatistics() {
//        //获取当天所有小程序用户行为
//        TodayVO todayVO = new TodayVO();
//        //今日概况 用户
//        //今日概况 优惠券
//        todayVO.setTodayCouponVO(getTodayCouponVO());
//        //今日概况 线索
//        todayVO.setTodayTrackVO(getTodayTrackVO());
//        //今日概况 其他
//        Map<String, Object> resultMap = new HashMap<>();
//        resultMap.put("data", todayVO);
//        return new Message("获取小程序今日用户行为分析", ErrorType.SUCCESS, resultMap);
//    }
//
//
//    /**
//     * @param
//     * @return TodayTrackVO
//     * @describe 获取今日线索
//     * @author 郑宇江
//     * @date 2019/12/9 17:40
//     **/
//    private TodayTrackVO getTodayTrackVO() {
//        Integer carEvaluateNum = carEvaluateDao.getCarEvaluateListSize(TimeUtils.getTodayStartTime());//二手车置换
//        Integer carMainteranceNum = carMainteranceDao.getCarMainteranceListSize(TimeUtils.getTodayStartTime());//维修保养
//        Integer carRoadHelpNum = carRoadHelpDao.getCarRoadHelpListSize(TimeUtils.getTodayStartTime());//道路救援
//        return TodayTrackVO.Builder.aTodayTrackVO().carEvaluateNum(carEvaluateNum).carMainteranceNum(carMainteranceNum).carRoadHelpNum(carRoadHelpNum).build();
//    }
//
//
//    private OtherConfigStaticsVO convertToOtherVO(Integer order,String datakey,String dataname,Integer num){
//        OtherConfigStaticsVO otherConfigStaticsVO=new OtherConfigStaticsVO();
//        otherConfigStaticsVO.setOrder(order);
//        otherConfigStaticsVO.setDatakey(datakey);
//        otherConfigStaticsVO.setDataname(dataname);
//        otherConfigStaticsVO.setNum(num);
//        return otherConfigStaticsVO;
//    }
//
//    /**
//     * @param behaviorMiniAppList
//     * @return TodayOtherVO
//     * @describe 获取今日其他
//     * @author 郑宇江
//     * @date 2019/12/9 17:25
//     **/
//    private List<OtherConfigStaticsVO> getTodayOtherVO(List<BehaviorMiniApp> behaviorMiniAppList) {
//        List<OtherConfigStaticsVO> todayList=new ArrayList<>();//今日
//
//        List<BehaviorMiniAppOtherConfig> otherConfigList = otherConfigDao.getBehaviorMiniAppOtherConfigList();
//
//        int num;
//        for(BehaviorMiniAppOtherConfig otherConfig : otherConfigList){
//            num= 0;
//            if(!CollectionUtils.isEmpty(behaviorMiniAppList)){
//                num=behaviorMiniAppList.stream().filter(v -> v.getOperatetype() == Integer.valueOf(otherConfig.getCid().toString())).map(v -> v.getMemberid()).collect(Collectors.toSet()).size();
//            }
//            //例如查保单
//            todayList.add(convertToOtherVO(Integer.valueOf(otherConfig.getCid().toString()),otherConfig.getDatakey(),otherConfig.getDataname(),num));
//        }
//
//        return todayList;
//    }
//
//
//    /**
//     * @param
//     * @return TodayCouponVO
//     * @describe 获取今日优惠券
//     * @author 郑宇江
//     * @date 2019/12/9 17:25
//     **/
//    private TodayCouponVO getTodayCouponVO() {
//        Integer usercollectNum = 0;//用户领券
//        Integer verNum = 0;//核销券
//        Integer couponshopNum = 0;//发券门店
//        Integer vershopNum = couponConsumerCollectDao.getCouponVerSize(TimeUtils.getTodayStartTime(), null);//核销门店
//        List<CouponConsumerCollect> couponConsumerList = couponConsumerCollectDao.getCouponConsumerByCondition(TimeUtils.getTodayStartTime());
//        if (!CollectionUtils.isEmpty(couponConsumerList)) {
//            usercollectNum = couponConsumerList.size();
//            couponshopNum = couponConsumerList.stream().map(v -> v.getShopid()).collect(Collectors.toSet()).size();
//            //核销门店
//            List<CouponConsumerCollect> verCouponList = couponConsumerList.stream().filter(v -> v.getCollectstate() == 3).collect(Collectors.toList());
//            if (!CollectionUtils.isEmpty(verCouponList)) {
//                verNum = verCouponList.size();
//            }
//        }
//        return TodayCouponVO.Builder.aTodayCouponVO().couponshopNum(couponshopNum).usercollectNum(usercollectNum).verNum(verNum).vershopNum(vershopNum).build();
//    }
//
//
//    /**
//     * @param behaviorMiniAppList
//     * @return TodayUserVO
//     * @describe 获取今日用户
//     * @author 郑宇江
//     * @date 2019/12/9 16:30
//     **/
//    private TodayUserVO getTodayUser(List<BehaviorMiniApp> behaviorMiniAppList) {
//        //获取所有员工证件号
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String startTime = sf.format(new Date());
//        List<String> employeePasscodeList = employeeDao.getAllEmployeeList();
//        Integer activitnum = 0;//活跃人数
//        Long activitemp = 0l;//活跃员工
//        //活跃用户
//        if (!CollectionUtils.isEmpty(behaviorMiniAppList)) {
//            Set<String> actMemidList = behaviorMiniAppList.stream().map(BehaviorMiniApp::getMemberid).collect(Collectors.toSet());
//            //活跃用户
//            activitnum = actMemidList.size();
//            List<String> activitPasscodeList = new ArrayList<>(getPasscodeList(new ArrayList<>(actMemidList)));
////            List<List<String>> list = ListUtil.getSumArrayList(new ArrayList<>(actMemidList), 1000);
////            for (List<String> itemlist : list) {
////                activitPasscodeList.addAll(userinfoDetailDao.getUserDetailByMemberidList(itemlist));
////            }
//            if (!CollectionUtils.isEmpty(activitPasscodeList)) {
//                //活跃员工
//                activitemp = employeePasscodeList.stream().filter(v -> activitPasscodeList.contains(v)).count();
//            }
//        }
//
//        //获取所有新增用户
//
//        logger.error("开始时间为" + startTime + "----结束时间为" + sf.format(new Date()));
//        return TodayUserVO.Builder.aTodayUserVO().activitemp(activitemp.intValue()).activitnum(activitnum).build();
//
//    }
//
//    @Override
//    public Message getTodayNewUserStatistics (){
//        List<String> employeePasscodeList = employeeDao.getAllEmployeeList();
//        Integer newusernum = 0;//新增用户
//        Long newuseremp = 0l;//新增员工
//        List<String> userWechatMemberidList = userWechatDao.getUserWechatList(TimeUtils.getTodayStartTime(), 1);
//        if (!CollectionUtils.isEmpty(userWechatMemberidList)) {
//            //新用户
//            newusernum = userWechatMemberidList.size();
//            List<String> newuserPasscodeList = new ArrayList<>(getPasscodeList(new ArrayList<>(userWechatMemberidList)));
////            List<List<String>> list = ListUtil.getSumArrayList(new ArrayList<>(userWechatMemberidList), 1000);
////            for (List<String> itemlist : list) {
////                newuserPasscodeList.addAll(userinfoDetailDao.getUserDetailByMemberidList(itemlist));
////            }
//            if (!CollectionUtils.isEmpty(newuserPasscodeList)) {
//                //新员工
//                newuseremp = employeePasscodeList.stream().filter(v -> newuserPasscodeList.contains(v)).count();
//            }
//        }
//        Map<String, Object> resultMap = new HashMap<>();
//        resultMap.put("data", TodayUserVO.Builder.aTodayUserVO().newuseremp(newuseremp.intValue()).newusernum(newusernum).build());
//        return  new Message("获取小程序今日新用户，新员工成功", ErrorType.SUCCESS, resultMap);
//    }
//
//
//
//    private List<String> getPasscodeList(List<String> menberidList){
//
//        List<String> newuserPasscodeList = new ArrayList<>();
//        try {
//            List<List<String>> list = ListUtil.getSumArrayList(new ArrayList<>(menberidList), 1000);
//            List<Callable<List>> tasks = new ArrayList<>();
//
//            for (List<String> itemlist : list) {
//                Callable<List> qfe = new ThredQueryPasscode(itemlist);
//                tasks.add(qfe);
//            }
//
//            //定义固定长度的线程池  防止线程过多
//            ExecutorService executorService = Executors.newFixedThreadPool(2);
//            //Future用于获取结果
//            List<Future<List>> futures = executorService.invokeAll(tasks);
//            //处理线程返回结果
//            if (futures != null && futures.size() > 0) {
//                for (Future<List> future : futures) {
//                    newuserPasscodeList.addAll(future.get());
//                }
//            }
//
//            executorService.shutdown();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            return newuserPasscodeList;
//        }
//    }
//
//
//
//    @Override
//    public Message getNotTodayStatistics() {
//
//        List<BehaviorMiniAppStatistics> statisticsList = behaviorMiniAppDao.getBehaviorMiniAppStatisticsList(TimeUtils.getBeforeDate(7), null,null,null);
//        if (CollectionUtils.isEmpty(statisticsList)) {
//            return new Message("数据为空", ErrorType.NODATA_ERROR);
//        }
//        //累计数据获取
//        List<BehaviorMiniAppStatistics> yesTodayStatisticsList = statisticsList.stream()
//                .filter(v -> v.getStatistictime().equals(TimeUtils.getBeforeDate(1)) && v.getDatakey().startsWith("LJ")).collect(Collectors.toList());
//        //累计7日数据
//        Map<String, Object> sevenDaysMap = new HashMap<>();
//        //近七天 用户
//        sevenDaysMap.putAll(getUserSevenDays(statisticsList));
//        //近七天优惠券
//        sevenDaysMap.putAll(getCouponSevenDays(statisticsList));
//        //近七天 线索
//        sevenDaysMap.putAll(getTrackSevenDays(statisticsList));
//
//        List<BehaviorMiniAppOtherConfig> otherConfigList = otherConfigDao.getBehaviorMiniAppOtherConfigList();
//
//        //近七天 其他
//        sevenDaysMap.put("other",getOtherSevenDays(statisticsList,otherConfigList));
//        //累计
//        sevenDaysMap.put("lj", yesTodayStatisticsList);
//
//        //累计其他
//        sevenDaysMap.put("ljother", getLJTodayOtherVO(yesTodayStatisticsList,otherConfigList));
//
//        return new Message("成功", ErrorType.SUCCESS, sevenDaysMap);
//    }
//
//
//    /**
//     * @param yesTodayStatisticsList
//     * @return TodayOtherVO
//     * @describe 获取今日其他
//     * @author 郑宇江
//     * @date 2019/12/9 17:25
//     **/
//    private List<OtherConfigStaticsVO> getLJTodayOtherVO(List<BehaviorMiniAppStatistics> yesTodayStatisticsList ,List<BehaviorMiniAppOtherConfig> otherConfigList) {
//        List<OtherConfigStaticsVO> ljList=new ArrayList<>();//累计其他
//
//
//        Map<String,BehaviorMiniAppStatistics> staticsMap=new HashMap<>();
//        if(!CollectionUtils.isEmpty(yesTodayStatisticsList)){
//            staticsMap.putAll(yesTodayStatisticsList.stream().collect(Collectors.toMap(BehaviorMiniAppStatistics::getDatakey, a ->a, (k1, k2) -> k1)));
//        }
//
//        int num;
//        for(BehaviorMiniAppOtherConfig otherConfig : otherConfigList){
//            num= 0;
//            if(staticsMap.get(otherConfig.getTotaldatakey())!=null){
//                num= staticsMap.get(otherConfig.getTotaldatakey()).getDatanum();
//            }
//            //例如累计查保单
//            ljList.add(convertToOtherVO(Integer.valueOf(otherConfig.getCid().toString()),otherConfig.getTotaldatakey(),otherConfig.getTotaldataname(),num));
//        }
//
//        return ljList;
//    }
//
//
//    /**
//     * @param statisticsList
//     * @return Object>
//     * @describe 近X天用户
//     * @author 郑宇江
//     * @date 2019/12/11 15:45
//     **/
//    private Map<String, Object> getUserSevenDays(List<BehaviorMiniAppStatistics> statisticsList) {
//        Map<String, Object> result = new HashMap<>();
//        List<BehaviorMiniAppStatistics> resultList;
//        for (SystemEnumType.MINIAPP_STATISTICS_USER miniapp_statistics : SystemEnumType.MINIAPP_STATISTICS_USER.values()) {
//            resultList = statisticsList.stream().filter(v -> v.getDatakey().equals(miniapp_statistics.key)).collect(Collectors.toList());
//            result.put(miniapp_statistics.name, resultList);
//        }
//        return result;
//    }
//
//
//    /**
//     * @param statisticsList
//     * @return Object>
//     * @describe 近X天优惠券
//     * @author 郑宇江
//     * @date 2019/12/11 15:45
//     **/
//    private Map<String, Object> getCouponSevenDays(List<BehaviorMiniAppStatistics> statisticsList) {
//        Map<String, Object> result = new HashMap<>();
//        List<BehaviorMiniAppStatistics> resultList;
//        for (SystemEnumType.MINIAPP_STATISTICS_COUPON miniapp_statistics : SystemEnumType.MINIAPP_STATISTICS_COUPON.values()) {
//            resultList = statisticsList.stream().filter(v -> v.getDatakey().equals(miniapp_statistics.key)).collect(Collectors.toList());
//            result.put(miniapp_statistics.name, resultList);
//        }
//        return result;
//    }
//
//
//    /**
//     * @param statisticsList
//     * @return Object>
//     * @describe 近X天线索
//     * @author 郑宇江
//     * @date 2019/12/11 15:46
//     **/
//    private Map<String, Object> getTrackSevenDays(List<BehaviorMiniAppStatistics> statisticsList) {
//        Map<String, Object> result = new HashMap<>();
//        List<BehaviorMiniAppStatistics> resultList;
//        for (SystemEnumType.MINIAPP_STATISTICS_TRACK miniapp_statistics : SystemEnumType.MINIAPP_STATISTICS_TRACK.values()) {
//            resultList = statisticsList.stream().filter(v -> v.getDatakey().equals(miniapp_statistics.key)).collect(Collectors.toList());
//            result.put(miniapp_statistics.name, resultList);
//        }
//        return result;
//    }
//
//
//
//
//
//    @Override
//    public Message getUserStatistics(String starttime, String endtime, Integer beforedays) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        List<BehaviorMiniAppStatistics> statisticsList = behaviorMiniAppDao.getBehaviorMiniAppStatisticsList(starttime, endtime,SystemEnumType.MINIAPP_STATISTICS_USER.getStatisticsKeyList(),null);
//        if (CollectionUtils.isEmpty(statisticsList)) {
//            return new Message("数据为空", ErrorType.NODATA_ERROR);
//        }
//        return new Message("成功", ErrorType.SUCCESS, getUserSevenDays(statisticsList));
//
//    }
//
//
//    @Override
//    public Message getUserStatisticsByPage(String starttime, String endtime, Integer beforedays, Integer pageindex, Integer pagesize) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        Map<String, Object> result = new HashMap<>();
//        int total = behaviorMiniAppDao.getBehaviorMiniAppStatisticsSize(starttime, endtime);
//        result.put("total", total);
//        if (total == 0) {
//            result.put("list", Collections.EMPTY_LIST);
//           return new Message("成功", ErrorType.SUCCESS, result);
//        }
//        if (total > pagesize) {
//            int endbeforedays=0;
//            if(!StringUtils.isEmptyOrWhitespaceOnly(endtime)){
//                endbeforedays=TimeUtils.getDaysBetweenTwoDate(endtime,TimeUtils.getDefaultCurrentTime())-2;
//            }
//            if(total<= pagesize * pageindex){
//                starttime = TimeUtils.getBeforeDate(total+endbeforedays );
//            }else{
//                starttime = TimeUtils.getBeforeDate(pagesize * pageindex +endbeforedays);
//            }
//            String enddate=TimeUtils.getBeforeDate(pagesize * (pageindex - 1)+1 +endbeforedays);
//            if((!StringUtils.isEmptyOrWhitespaceOnly(endtime)&&enddate.compareTo(endtime)<0)||StringUtils.isEmptyOrWhitespaceOnly(endtime)){
//                endtime = enddate;
//            }
//        }
//        List<UserStatisticsPageVO> userStatisticsList = behaviorMiniAppDao.getUserStatisticsPage(starttime, endtime, SystemEnumType.MINIAPP_STATISTICS_USER.getStatisticsKeyList());
//        result.put("list", userStatisticsList);
//        return new Message("成功", ErrorType.SUCCESS, result);
//    }
//
//
//    @Override
//    public void exportUserStatistics(String starttime, String endtime, Integer beforedays, HttpServletResponse response) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        List<UserStatisticsPageVO> userStatisticsList = behaviorMiniAppDao.getUserStatisticsPage(starttime, endtime, SystemEnumType.MINIAPP_STATISTICS_USER.getStatisticsKeyList());
//        exportUserStatisticsList(userStatisticsList, response);
//    }
//
//
//    /**
//     * @param userStatisticsList
//     * @param response
//     * @return void
//     * @describe 方法描述
//     * @author 郑宇江
//     * @date 2019/12/12 14:46
//     **/
//    private void exportUserStatisticsList(List<UserStatisticsPageVO> userStatisticsList, HttpServletResponse response) {
//        // 导出Excel excel标题
//        String[] title = {"序号", "日期", "新增用户", "累计用户", "活跃用户", "新增员工", "累计员工", "活跃员工"};
//
//        //excel文件名
//        String fileName = "用户分析详细信息.xlsx";
//        //sheet名
//        String sheetName = "用户分析";
//        //设置 二维数组的长度 X行Y列
//        String[][] content = new String[userStatisticsList.size()][title.length];
//        UserStatisticsPageVO userStatisticsPageVO;
//        for (int i = 0; i < userStatisticsList.size(); i++) {
//            userStatisticsPageVO = userStatisticsList.get(i);
//            content[i][0] = i + 1 + "";//序号
//            content[i][1] = userStatisticsPageVO.getStatistictime();//日期
//            content[i][2] = userStatisticsPageVO.getXzyh() + "";//新增用户
//            content[i][3] = userStatisticsPageVO.getLjyh() + "";//累计用户
//            content[i][4] = userStatisticsPageVO.getHyyh() + "";//活跃用户
//            content[i][5] = userStatisticsPageVO.getXzyh() + "";//新增员工
//            content[i][6] = userStatisticsPageVO.getLjyg() + "";//累计员工
//            content[i][7] = userStatisticsPageVO.getHyyg() + "";//活跃员工
//        }
//
//        //创建HSSFWorkbook
//        SXSSFWorkbook wb = getHSSFWorkbook(sheetName, title, content, null, sheetName);
//
//        //响应到客户端
//        setResponseHeader(response, fileName);
//        OutputStream os = null;
//        try {
//            os = response.getOutputStream();
//            wb.write(os);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                os.flush();
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//
//    @Override
//    public Message getUserAnalysis() {
//        List<BehaviorMiniAppStatistics> statisticsList = behaviorMiniAppDao.getBehaviorMiniAppStatisticsList(TimeUtils.getBeforeDate(1), null,null,null);
//        if(CollectionUtils.isEmpty(statisticsList)){
//            return new Message("数据为空", ErrorType.NODATA_ERROR);
//        }
//        Map<String, BehaviorMiniAppStatistics> statisticsMap = statisticsList.stream()
//                .collect(Collectors.toMap(BehaviorMiniAppStatistics::getDatakey, a -> a, (k1, k2) -> k1));
//        Map<String, Object> result = new HashMap<>();
//        //用户分布
//        result.put("userDistribution", getUserDistribution(statisticsList));
//        result.put("employeeDistribution", getEmployeeDistribution(statisticsMap));
//        result.put("userBingDistribution", getUserBingDistribution(statisticsMap));
//        return new Message("成功", ErrorType.SUCCESS, result);
//    }
//
//
//    /**
//     * @describe 获取绑定用户占比
//     * @author 郑宇江
//     * @date 2019/12/12 16:18
//     * @param statisticsMap
//     * @return UserBingDistributionVO>
//     **/
//    private List<UserBingDistributionVO> getUserBingDistribution(Map<String, BehaviorMiniAppStatistics> statisticsMap){
//        List<UserBingDistributionVO> userBingDistributionList = new ArrayList<>();
//        BehaviorMiniAppStatistics bing=statisticsMap.get(SystemEnumType.MINIAPP_STATISTICS_USER.YBDYH.key);
//        BehaviorMiniAppStatistics all=statisticsMap.get(SystemEnumType.MINIAPP_STATISTICS_USER.LJYH.key);
//        int sum = all.getDatanum();
//        BigDecimal bingPercent = new BigDecimal(bing.getDatanum()).multiply(new BigDecimal(100)).divide(new BigDecimal(sum),2, BigDecimal.ROUND_HALF_UP);
//        BigDecimal notBingPercent = new BigDecimal(sum-bing.getDatanum()).multiply(new BigDecimal(100)).divide(new BigDecimal(sum),2, BigDecimal.ROUND_HALF_UP);
//        userBingDistributionList.add(UserBingDistributionVO.Builder.anUserBingDistributionVO()
//                .isBinging(1).num(bing.getDatanum()).percentage(bingPercent.toString() + "%").build());
//        userBingDistributionList.add(UserBingDistributionVO.Builder.anUserBingDistributionVO()
//                .isBinging(0).num(sum-bing.getDatanum()).percentage(notBingPercent.toString() + "%").build());
//        return userBingDistributionList;
//    }
//
//    /**
//     * @describe 获取员工用户占比
//     * @author 郑宇江
//     * @date 2019/12/12 16:12
//     * @param statisticsMap
//     * @return EmployeeDistributionVO>
//     **/
//    private List<EmployeeDistributionVO> getEmployeeDistribution(Map<String, BehaviorMiniAppStatistics> statisticsMap){
//        List<EmployeeDistributionVO> employeeDistributionList = new ArrayList<>();
//        BehaviorMiniAppStatistics emp=statisticsMap.get(SystemEnumType.MINIAPP_STATISTICS_USER.LJYG.key);
//        BehaviorMiniAppStatistics all=statisticsMap.get(SystemEnumType.MINIAPP_STATISTICS_USER.LJYH.key);
//        int sum = all.getDatanum();
//        BigDecimal empPercent = new BigDecimal(emp.getDatanum()).multiply(new BigDecimal(100)).divide(new BigDecimal(sum),2, BigDecimal.ROUND_HALF_UP);
//        BigDecimal notEmpPercent = new BigDecimal(sum-emp.getDatanum()).multiply(new BigDecimal(100)).divide(new BigDecimal(sum),2, BigDecimal.ROUND_HALF_UP);
//        employeeDistributionList.add(EmployeeDistributionVO.Builder.anEmployeeDistributionVO()
//                .isEmployee(1).num(emp.getDatanum()).percentage(empPercent.toString() + "%").build());
//        employeeDistributionList.add(EmployeeDistributionVO.Builder.anEmployeeDistributionVO()
//                .isEmployee(0).num(sum-emp.getDatanum()).percentage(notEmpPercent.toString() + "%").build());
//        return employeeDistributionList;
//    }
//
//
//    /**
//     * @param statisticsList
//     * @return UserDistributionVO>
//     * @describe 获取用户分布地区list
//     * @author 郑宇江
//     * @date 2019/12/12 15:46
//     **/
//    private List<UserDistributionVO> getUserDistribution(List<BehaviorMiniAppStatistics> statisticsList) {
//        //绑定用户分布list
//        List<BehaviorMiniAppStatistics> bdyhfbList = statisticsList.stream()
//                .filter(v -> v.getDatakey().startsWith(SystemEnumType.MINIAPP_STATISTICS_USER.BDYHFB.key)).collect(Collectors.toList());
//        List<UserDistributionVO> userDistributionVOList = new ArrayList<>();
//        if (!CollectionUtils.isEmpty(bdyhfbList)) {
//
//            UserDistributionVO userDistributionVO;
//            String code;
//            BigDecimal bd;
//            double sum = bdyhfbList.stream().mapToDouble(BehaviorMiniAppStatistics::getDatanum).sum();
//            for (BehaviorMiniAppStatistics statistics : bdyhfbList) {
//                userDistributionVO = new UserDistributionVO();
//                code = statistics.getDatakey().replace(SystemEnumType.MINIAPP_STATISTICS_USER.BDYHFB.key + 3, "");
//                userDistributionVO.setCode(code);
//                userDistributionVO.setName(RegExpUtils.cityCodes.get(code));
//                userDistributionVO.setNum(statistics.getDatanum());
//                bd = new BigDecimal(statistics.getDatanum() * 100 / sum);
//                userDistributionVO.setPercentage(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "%");
//                userDistributionVOList.add(userDistributionVO);
//            }
//            //排序
//            Collections.sort(userDistributionVOList, new Comparator<UserDistributionVO>() {
//                public int compare(UserDistributionVO a1, UserDistributionVO a2) {
//                    if (a1.getNum().compareTo(a2.getNum()) > 0) {
//                        return -1;
//                    }
//                    if (a2.getNum().compareTo(a1.getNum()) == 0){
//                        return 0;
//                    }
//                    return 1;
//                }
//            });
//        }
//        return userDistributionVOList;
//    }
//
//
//
//    @Override
//    public Message getCouponStatistics(String starttime, String endtime, Integer beforedays) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        List<BehaviorMiniAppStatistics> statisticsList = behaviorMiniAppDao.getBehaviorMiniAppStatisticsList(starttime, endtime,SystemEnumType.MINIAPP_STATISTICS_COUPON.getStatisticsKeyList(),null);
//        if (CollectionUtils.isEmpty(statisticsList)) {
//            return new Message("数据为空", ErrorType.NODATA_ERROR);
//        }
//        return new Message("成功", ErrorType.SUCCESS, getCouponSevenDays(statisticsList));
//
//    }
//
//
//    @Override
//    public Message getCouponStatisticsByPage(String starttime, String endtime, Integer beforedays, Integer pageindex, Integer pagesize) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        Map<String, Object> result = new HashMap<>();
//        int total = behaviorMiniAppDao.getBehaviorMiniAppStatisticsSize(starttime, endtime);
//        result.put("total", total);
//        if (total == 0) {
//            result.put("list", Collections.EMPTY_LIST);
//            return new Message("成功", ErrorType.SUCCESS, result);
//        }
//        if (total > pagesize) {
//            int endbeforedays=0;
//            if(!StringUtils.isEmptyOrWhitespaceOnly(endtime)){
//                endbeforedays=TimeUtils.getDaysBetweenTwoDate(endtime,TimeUtils.getDefaultCurrentTime())-2;
//            }
//            if(total<= pagesize * pageindex){
//                starttime = TimeUtils.getBeforeDate(total+endbeforedays );
//            }else{
//                starttime = TimeUtils.getBeforeDate(pagesize * pageindex +endbeforedays);
//            }
//            String enddate=TimeUtils.getBeforeDate(pagesize * (pageindex - 1)+1+endbeforedays );
//            if((!StringUtils.isEmptyOrWhitespaceOnly(endtime)&&enddate.compareTo(endtime)<0)||StringUtils.isEmptyOrWhitespaceOnly(endtime)){
//                endtime = enddate;
//            }
//        }
//        List<CouponStatisticsPageVO> couponStatisticsList = behaviorMiniAppDao.getCouponStatisticsPage(starttime, endtime, SystemEnumType.MINIAPP_STATISTICS_COUPON.getStatisticsKeyList());
//        result.put("list", couponStatisticsList);
//        return new Message("成功", ErrorType.SUCCESS, result);
//    }
//
//
//    @Override
//    public void exportCouponStatistics(String starttime, String endtime, Integer beforedays, HttpServletResponse response) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        List<CouponStatisticsPageVO> couponStatisticsList = behaviorMiniAppDao.getCouponStatisticsPage(starttime, endtime, SystemEnumType.MINIAPP_STATISTICS_COUPON.getStatisticsKeyList());
//        exportCouponStatisticsList(couponStatisticsList, response);
//    }
//
//
//    /**
//     * @param couponStatisticsList
//     * @param response
//     * @return void
//     * @describe 导出优惠券分析
//     * @author 郑宇江
//     * @date 2019/12/12 14:46
//     **/
//    private void exportCouponStatisticsList(List<CouponStatisticsPageVO> couponStatisticsList, HttpServletResponse response) {
//        // 导出Excel excel标题
//        String[] title = {"序号","日期", "用户领券", "累计领券", "核销券", "累计核销券", "成功发券门店", "累计成功发券门店", "成功核销门店","累计成功核销门店"};
//
//        //excel文件名
//        String fileName = "优惠券分析详细信息.xlsx";
//        //sheet名
//        String sheetName = "优惠券分析";
//        //设置 二维数组的长度 X行Y列
//        String[][] content = new String[couponStatisticsList.size()][title.length];
//        CouponStatisticsPageVO couponStatisticsPageVO;
//        for (int i = 0; i < couponStatisticsList.size(); i++) {
//            couponStatisticsPageVO = couponStatisticsList.get(i);
//            content[i][0] = i + 1 + "";//序号
//            content[i][1] = couponStatisticsPageVO.getStatistictime();//日期
//            content[i][2] = couponStatisticsPageVO.getYhlq() + "";//用户领券
//            content[i][3] = couponStatisticsPageVO.getLjlq() + "";//累计领券
//            content[i][4] = couponStatisticsPageVO.getHxq() + "";//核销券
//            content[i][5] = couponStatisticsPageVO.getLjhxq() + "";//累计核销券
//            content[i][6] = couponStatisticsPageVO.getFqmd() + "";//成功发券门店
//            content[i][7] = couponStatisticsPageVO.getLjfqmd() + "";//累计成功发券门店
//            content[i][8] = couponStatisticsPageVO.getHxmd() + "";//成功核销门店
//            content[i][9] = couponStatisticsPageVO.getLjhxmd() + "";//累计成功核销门店
//        }
//
//        //创建HSSFWorkbook
//        SXSSFWorkbook wb = getHSSFWorkbook(sheetName, title, content, null, sheetName);
//
//        //响应到客户端
//        setResponseHeader(response, fileName);
//        OutputStream os = null;
//        try {
//            os = response.getOutputStream();
//            wb.write(os);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                os.flush();
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//
//    @Override
//    public Message getTrackStatistics(String starttime, String endtime, Integer beforedays) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        List<BehaviorMiniAppStatistics> statisticsList = behaviorMiniAppDao.getBehaviorMiniAppStatisticsList(starttime, endtime,SystemEnumType.MINIAPP_STATISTICS_TRACK.getStatisticsKeyList(),null);
//        if (CollectionUtils.isEmpty(statisticsList)) {
//            return new Message("数据为空", ErrorType.NODATA_ERROR);
//        }
//        return new Message("成功", ErrorType.SUCCESS, getTrackSevenDays(statisticsList));
//
//    }
//
//
//    @Override
//    public Message getTrackStatisticsByPage(String starttime, String endtime, Integer beforedays, Integer pageindex, Integer pagesize) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        Map<String, Object> result = new HashMap<>();
//        int total = behaviorMiniAppDao.getBehaviorMiniAppStatisticsSize(starttime, endtime);
//        result.put("total", total);
//        if (total == 0) {
//            result.put("list", Collections.EMPTY_LIST);
//            return new Message("成功", ErrorType.SUCCESS, result);
//        }
//        if (total > pagesize) {
//            int endbeforedays=0;
//            if(!StringUtils.isEmptyOrWhitespaceOnly(endtime)){
//                endbeforedays=TimeUtils.getDaysBetweenTwoDate(endtime,TimeUtils.getDefaultCurrentTime())-2;
//            }
//            if(total<= pagesize * pageindex){
//                starttime = TimeUtils.getBeforeDate(total+endbeforedays );
//            }else{
//                starttime = TimeUtils.getBeforeDate(pagesize * pageindex +endbeforedays);
//            }
//            String enddate=TimeUtils.getBeforeDate(pagesize * (pageindex - 1)+1+endbeforedays );
//            if((!StringUtils.isEmptyOrWhitespaceOnly(endtime)&&enddate.compareTo(endtime)<0)||StringUtils.isEmptyOrWhitespaceOnly(endtime)){
//                endtime = enddate;
//            }
//        }
//        List<TrackStatisticsPageVO> trackStatisticsList = behaviorMiniAppDao.getTrackStatisticsPage(starttime, endtime, SystemEnumType.MINIAPP_STATISTICS_TRACK.getStatisticsKeyList());
//        result.put("list", trackStatisticsList);
//        return new Message("成功", ErrorType.SUCCESS, result);
//    }
//
//
//    @Override
//    public void exportTrackStatistics(String starttime, String endtime, Integer beforedays, HttpServletResponse response) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        List<TrackStatisticsPageVO> trackStatisticsList = behaviorMiniAppDao.getTrackStatisticsPage(starttime, endtime, SystemEnumType.MINIAPP_STATISTICS_TRACK.getStatisticsKeyList());
//        exportTrackStatisticsList(trackStatisticsList, response);
//    }
//
//
//    /**
//     * @param trackStatisticsList
//     * @param response
//     * @return void
//     * @describe 导出线索分析
//     * @author 郑宇江
//     * @date 2019/12/12 14:46
//     **/
//    private void exportTrackStatisticsList(List<TrackStatisticsPageVO> trackStatisticsList, HttpServletResponse response) {
//        // 导出Excel excel标题
//        String[] title = {"序号","日期", "二手车置换线索", "道路救援线索", "维修保养线索"};
//
//        //excel文件名
//        String fileName = "线索分析详细信息.xlsx";
//        //sheet名
//        String sheetName = "线索分析";
//        //设置 二维数组的长度 X行Y列
//        String[][] content = new String[trackStatisticsList.size()][title.length];
//        TrackStatisticsPageVO trackStatisticsPageVO;
//        for (int i = 0; i < trackStatisticsList.size(); i++) {
//            trackStatisticsPageVO = trackStatisticsList.get(i);
//            content[i][0] = i + 1 + "";//序号
//            content[i][1] = trackStatisticsPageVO.getStatistictime();//日期
//            content[i][2] = trackStatisticsPageVO.getEsczh() + "";//二手车置换线索
//            content[i][3] = trackStatisticsPageVO.getDljy() + "";//道路救援线索
//            content[i][4] = trackStatisticsPageVO.getWxby() + "";//维修保养线索
//        }
//
//        //创建HSSFWorkbook
//        SXSSFWorkbook wb = getHSSFWorkbook(sheetName, title, content, null, sheetName);
//
//        //响应到客户端
//        setResponseHeader(response, fileName);
//        OutputStream os = null;
//        try {
//            os = response.getOutputStream();
//            wb.write(os);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                os.flush();
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//
//    /**
//     * @param statisticsList
//     * @return Object>
//     * @describe 近X天其他
//     * @author 郑宇江
//     * @date 2019/12/11 15:47
//     **/
//    private Map<String, Object> getOtherSevenDays(List<BehaviorMiniAppStatistics> statisticsList,List<BehaviorMiniAppOtherConfig> otherConfigList) {
//        Map<String, Object> result = new HashMap<>();
//        LinkedHashSet<String> dateSets = new LinkedHashSet<>();
//        statisticsList.forEach(v -> dateSets.add(v.getStatistictime()));
//        List<BehaviorMiniAppStatistics> dataStatisticsList;
//        BehaviorMiniAppStatistics behaviorStatistics;
//        Map<String,BehaviorMiniAppStatistics> statisticsMap;
//        List<BehaviorMiniAppStatistics> resultList;
//        for (BehaviorMiniAppOtherConfig otherConfig : otherConfigList) {
//            dataStatisticsList = new ArrayList<>();
//            resultList = statisticsList.stream().filter(v -> v.getDatakey().equals(otherConfig.getDatakey())).collect(Collectors.toList());
//            statisticsMap = resultList.stream().collect(Collectors.toMap(BehaviorMiniAppStatistics :: getStatistictime, a->a,(k1,k2)->k1));;
//            for(String date:dateSets){
//                if(statisticsMap.get(date)!=null){
//                    dataStatisticsList.add(statisticsMap.get(date));
//                }else{
//                    behaviorStatistics = new BehaviorMiniAppStatistics();
//                    behaviorStatistics.setStatistictime(date);
//                    behaviorStatistics.setDatakey(otherConfig.getDatakey());
//                    behaviorStatistics.setDatanum(0);
//                    dataStatisticsList.add(behaviorStatistics);
//                }
//            }
//            result.put(otherConfig.getDataname(), dataStatisticsList);
//        }
//        return result;
//    }
//
//    @Override
//    public Message getOtherStatistics(String starttime, String endtime, Integer beforedays) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//
//        List<BehaviorMiniAppOtherConfig> otherConfigList = otherConfigDao.getBehaviorMiniAppOtherConfigList();
//        List<String> keyList = otherConfigList.stream().map(BehaviorMiniAppOtherConfig::getDatakey).collect(Collectors.toList());
//
//        List<BehaviorMiniAppStatistics> statisticsList = behaviorMiniAppDao.getBehaviorMiniAppStatisticsList(starttime, endtime,keyList,null);
//        if (CollectionUtils.isEmpty(statisticsList)) {
//            return new Message("数据为空", ErrorType.NODATA_ERROR);
//        }
//        return new Message("成功", ErrorType.SUCCESS, getOtherSevenDays(statisticsList,otherConfigList));
//
//    }
//
//
//    @Override
//    public Message getOtherStatisticsByPage(String starttime, String endtime, Integer beforedays, Integer pageindex, Integer pagesize) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//        Map<String, Object> result = new HashMap<>();
//        int total = behaviorMiniAppDao.getBehaviorMiniAppStatisticsSize(starttime, endtime);
//        result.put("total", total);
//        if (total == 0) {
//            result.put("list", Collections.EMPTY_LIST);
//            return new Message("成功", ErrorType.SUCCESS, result);
//        }
//        if (total > pagesize) {
//            int endbeforedays=0;
//            if(!StringUtils.isEmptyOrWhitespaceOnly(endtime)){
//                endbeforedays=TimeUtils.getDaysBetweenTwoDate(endtime,TimeUtils.getDefaultCurrentTime())-2;
//            }
//            if(total<= pagesize * pageindex){
//                starttime = TimeUtils.getBeforeDate(total+endbeforedays );
//            }else{
//                starttime = TimeUtils.getBeforeDate(pagesize * pageindex +endbeforedays);
//            }
//            String enddate=TimeUtils.getBeforeDate(pagesize * (pageindex - 1)+1 +endbeforedays);
//            if((!StringUtils.isEmptyOrWhitespaceOnly(endtime)&&enddate.compareTo(endtime)<0)||StringUtils.isEmptyOrWhitespaceOnly(endtime)){
//                endtime = enddate;
//            }
//        }
//        List<BehaviorMiniAppOtherConfig> otherConfigList = otherConfigDao.getBehaviorMiniAppOtherConfigList();
//        List<String> keyList = otherConfigList.stream().map(BehaviorMiniAppOtherConfig::getDatakey).collect(Collectors.toList());
//        List<BehaviorMiniAppStatistics> statisticsList = behaviorMiniAppDao.getBehaviorMiniAppStatisticsList(starttime, endtime,keyList,1);
//
//
////        List<OtherStatisticsPageVO> otherStatisticsList = behaviorMiniAppDao.getOtherStatisticsPage(starttime, endtime, SystemEnumType.MINIAPP_STATISTICS_OTHER.getStatisticsKeyList());
//        result.put("title", otherConfigList);
//        result.put("list", getOtherList( otherConfigList,  statisticsList));
//        return new Message("成功", ErrorType.SUCCESS, result);
//    }
//
//
//    /***
//     * 组装其他分析
//     * @param otherConfigList
//     * @param statisticsList
//     * @return
//     */
//    private List<Map<String, String>> getOtherList(List<BehaviorMiniAppOtherConfig> otherConfigList, List<BehaviorMiniAppStatistics> statisticsList) {
//        LinkedList<Map<String, String>> resultList = new LinkedList<>();
//        Map<String, String> dataMap;
//        if (!CollectionUtils.isEmpty(statisticsList)) {
//            LinkedHashSet<String> dateSets = new LinkedHashSet<>();
//            List<BehaviorMiniAppStatistics> dataStatisticsList;
//            statisticsList.forEach(v -> dateSets.add(v.getStatistictime()));
//            for (String key : dateSets) {
//                dataMap = new HashMap<>();
//                dataMap.put("statistictime", key);
//                for (BehaviorMiniAppOtherConfig otherConfig : otherConfigList) {
//                    dataStatisticsList = statisticsList.stream().filter(v -> v.getStatistictime().equals(key)
//                            && v.getDatakey().equals(otherConfig.getDatakey())).collect(Collectors.toList());
//                    if(!CollectionUtils.isEmpty(dataStatisticsList)){
//                        dataMap.put(otherConfig.getDatakey(), dataStatisticsList.get(0).getDatanum()+"");
//                    }else{
//                        dataMap.put(otherConfig.getDatakey(), "0");
//                    }
//                }
//                resultList.add(dataMap);
//            }
//        }
//        return resultList;
//    }
//
//
//    @Override
//    public void exportOtherStatistics(String starttime, String endtime, Integer beforedays, HttpServletResponse response) {
//        if (beforedays != null) {
//            starttime = TimeUtils.getBeforeDate(beforedays);
//        }
//
//        List<BehaviorMiniAppOtherConfig> otherConfigList = otherConfigDao.getBehaviorMiniAppOtherConfigList();
//        List<String> keyList = otherConfigList.stream().map(BehaviorMiniAppOtherConfig::getDatakey).collect(Collectors.toList());
//        List<BehaviorMiniAppStatistics> statisticsList = behaviorMiniAppDao.getBehaviorMiniAppStatisticsList(starttime, endtime,keyList,1);
//
////        List<OtherStatisticsPageVO> otherStatisticsList = behaviorMiniAppDao.getOtherStatisticsPage(starttime, endtime, SystemEnumType.MINIAPP_STATISTICS_OTHER.getStatisticsKeyList());
//        exportOtherStatisticsList(getOtherList( otherConfigList,  statisticsList), otherConfigList, response);
//    }
//
//
//    private List<OtherStatisticsPageVO> delnull(List<OtherStatisticsPageVO> otherStatisticsList){
//        List<OtherStatisticsPageVO> result = new ArrayList<>();
//        for(OtherStatisticsPageVO other :otherStatisticsList){
//            if(other.getFy()==null){
//                other.setFy(0);
//            }
//            if(other.getOpde()==null){
//                other.setOpde(0);
//            }
//            if(other.getOp()==null){
//                other.setOp(0);
//            }
//            result.add(other);
//        }
//        return result;
//    }
//
//    /**
//     * @param
//     * @param response
//     * @return void
//     * @describe 导出线索分析
//     * @author 郑宇江
//     * @date 2019/12/12 14:46
//     **/
//    private void exportOtherStatisticsList(List<Map<String, String>> otherStatisticsMapList, List<BehaviorMiniAppOtherConfig> otherConfigList ,HttpServletResponse response) {
//        // 导出Excel excel标题
//       LinkedList<String> titleList = new LinkedList<>();
//        titleList.add("序号");titleList.add("日期");
//        titleList.addAll(otherConfigList.stream().map(BehaviorMiniAppOtherConfig::getDataname).collect(Collectors.toList()));
//        String[] title = titleList.toArray(new String[titleList.size()]);
////                {"序号","日期", "申请理赔", "查保单", "查违章", "出险值不值", "验真" ,"自选方案" ,"自选方案详情" ,"爱心保"};
//
//        //excel文件名
//        String fileName = "其他分析详细信息.xlsx";
//        //sheet名
//        String sheetName = "其他分析";
//        //设置 二维数组的长度 X行Y列
//        String[][] content = new String[otherStatisticsMapList.size()][title.length];
//        Map<String, String> otherStatisticsMap;
//        for (int i = 0; i < otherStatisticsMapList.size(); i++) {
//            otherStatisticsMap = otherStatisticsMapList.get(i);
//            content[i][0] = i + 1 + "";//序号
//            content[i][1] = otherStatisticsMap.get("statistictime");//日期
//            for(int j=0;j< otherConfigList.size();j++){
//                content[i][j+2] = otherStatisticsMap.get(otherConfigList.get(j).getDatakey()) ;//例如申请理赔
//            }
//        }
//
//        //创建HSSFWorkbook
//        SXSSFWorkbook wb = getHSSFWorkbook(sheetName, title, content, null, sheetName);
//
//        //响应到客户端
//        setResponseHeader(response, fileName);
//        OutputStream os = null;
//        try {
//            os = response.getOutputStream();
//            wb.write(os);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                os.flush();
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//
//
//
//    /**
//     * 设置 excel
//     *
//     * @param sheetName
//     * @param title
//     * @param values
//     * @param wb
//     * @return
//     */
//    private SXSSFWorkbook getHSSFWorkbook(String sheetName, String[] title,
//                                          String[][] values, SXSSFWorkbook wb, String titleName) {
//        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
//        if (wb == null) {
//            wb = new SXSSFWorkbook();
//        }
//
//        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
//        SXSSFSheet sheet = wb.createSheet(sheetName);
//
//        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
//        SXSSFRow titleRow = sheet.createRow(0); //创建第一行
//        titleRow.setHeightInPoints(36);
//
//        // 第四步，创建单元格，并设置值表头 设置表头居中
//        CellStyle style = wb.createCellStyle();
//
//        // 设置 字体
//        Font titleFont = wb.createFont();
//        titleFont.setFontName("黑体");
//        titleFont.setFontHeightInPoints((short) 20);//设置字体大小
//        titleFont.setBold(true);//设置是否加粗
//        style.setFont(titleFont);
//        //设置样式 - 边框属性 居中
//        setStyle(style);
//
//        //声明列对象
//        SXSSFCell cell = null;
//        //第一行 大标题标题 并合并
//        cell = titleRow.createCell(0);
//        cell.setCellValue(titleName);
//        // 构造参数 起始行，截至行，起始列， 截至列
//        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, title.length - 1));
//        cell.setCellStyle(style);
//
//        //第二行 创建标题 字体
//        CellStyle firstStyle = wb.createCellStyle();
//        setStyle(firstStyle);
//
//        // 设置 字体
//        Font bodyFont = wb.createFont();
//        bodyFont.setFontName("宋体");
//        bodyFont.setFontHeightInPoints((short) 12);
//        firstStyle.setFont(bodyFont); //设置 body 字体
//        firstStyle.setWrapText(true); //单元格内容自动换行
//
//        SXSSFRow firstRow = sheet.createRow(1); //创建第二行
//        firstRow.setHeightInPoints(42);
//        for (int i = 0; i < title.length; i++) {
//            cell = firstRow.createCell(i); //从第二行开始
//            cell.setCellValue(title[i]);
//            cell.setCellStyle(firstStyle);
//            sheet.setColumnWidth(i, 4200);
//        }
//        // 特殊 调整 几行
//        sheet.setColumnWidth(1, 10000);
//        sheet.setColumnWidth(12, 7000);
//        sheet.setColumnWidth(14, 7000);
//        sheet.setColumnWidth(18, 7000);
//        sheet.setColumnWidth(20, 7000);
//        sheet.setColumnWidth(21, 7000);
//        sheet.setColumnWidth(25, 7000);
//
//
//        //设置内容 样式
//        CellStyle bodyStyle = wb.createCellStyle();
//        setStyle(bodyStyle);
//        bodyStyle.setFont(bodyFont);
//
//        //创建内容
//        for (int i = 0; i < values.length; i++) {
//            SXSSFRow row = sheet.createRow(i + 2);
//            row.setHeightInPoints(20);
//            for (int j = 0; j < values[i].length; j++) {
//                //将内容按顺序赋给对应的列对象
//                Cell bodyCell = row.createCell(j);
//                bodyCell.setCellValue(values[i][j]);
//                bodyCell.setCellStyle(bodyStyle);
//            }
//        }
//        return wb;
//    }
//
//    /**
//     * 设置 单元格样式
//     *
//     * @param style
//     */
//    private void setStyle(CellStyle style) {
//        style.setAlignment(HorizontalAlignment.CENTER);//水平居中
//        style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
//        //设置样式 - 边框属性
//        style.setBorderBottom(BorderStyle.THIN);//下边框
//        style.setBorderLeft(BorderStyle.THIN);//左边框
//        style.setBorderRight(BorderStyle.THIN);//右边框
//        style.setBorderTop(BorderStyle.THIN); //上边框
//    }
//
//
//    /**
//     * 发送响应流方法
//     */
//    private void setResponseHeader(HttpServletResponse response, String fileName) {
//        try {
//            try {
//                fileName = new String(fileName.getBytes(), "ISO8859-1");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            response.setContentType("application/octet-stream;charset=ISO8859-1");
//            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//            response.addHeader("Pargam", "no-cache");
//            response.addHeader("Cache-Control", "no-cache");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//
//}
