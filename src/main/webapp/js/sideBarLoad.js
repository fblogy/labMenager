var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);
//全局变量设置两个都为关闭状态
var dailyB=false;
var underB=false;
$(document).ready(function(){
    var AD=`
    <p class="navP" style="" onclick="location.href='index.html'">首页</p>
    <p class="navP" style="" onclick="switchOpenDaily()">日常管理
        <img src="./img/Dirdown.png" height="15px" style="padding-left: 60px;"/>
    </p>
        <div id="dailyBlock" style="display:none">
            <p class="navP navP2" style="" onclick="location.href='daily.html'">日常安排</p>
            <p class="navP navP2" style="" onclick="location.href='desk.html'">工作位安排</p>
            <p class="navP navP2" style="" onclick="location.href='room.html'">会议室租借</p>
        </div>
    <p class="navP" style="" onclick="switchOpenUderB()">本科生模块
        <img src="./img/Dirdown.png" height="15px" style="padding-left: 45px;"/>
    </p>
        <div id="undergBlock" style="display:none">
            <p class="navP navP2" style="" onclick="location.href='allTaskTL.html'">小组作业</p>
            <p class="navP navP2" style="" onclick="location.href='allProjAD.html'">项目报名</p>
            <p class="navP navP2" style="" onclick="location.href='gradeRecordAD.html'">查看积分</p>
            <p class="navP navP2" style="" onclick="location.href='weekTask.html'">周计划</p>
        </div>
    <p class="navP" style="" onclick="location.href='bachelorBlock.html'">研究生模块</p>
    <p class="navP" style="" onclick="location.href='activityAllAD.html'">活动组织</p>
    <p class="navP" style="" onclick="location.href='fundProj.html'">项目展示</p>

    <p class="navP" style="" onclick="location.href='bookAllAD.html'">图书管理</p>

    <p class="navP" style="" onclick="location.href='goodMng.html'">物资管理</p>
    `;
    var SU=AD+`<p class="navP" style="" onclick="location.href='userMng.html'">用户管理</p>`;
    var UDBC=`
    <p class="navP" style="" onclick="location.href='index.html'">首页</p>
    <p class="navP navSpread" style="" onclick="switchOpenDaily(this)" data-open="0">日常管理
        <img src="./img/Dirdown.png" height="15px" style="padding-left: 60px;"/>
    </p>
        <div id="dailyBlock" style="display:none">
            <p class="navP navP2" style="" onclick="location.href='daily.html'">日常安排</p>
            <p class="navP navP2" style="" onclick="location.href='desk.html'">工作位安排</p>
            <p class="navP navP2" style="" onclick="location.href='room.html'">会议室租借</p>
        </div>
        <p class="navP navSpread" style="" onclick="switchOpenUderB(this)" data-open="0">本科生模块
            <img src="./img/Dirdown.png" height="15px" style="padding-left: 45px;"/>
        </p>
        <div id="undergBlock" style="display:none">
            <p class="navP navP2" style="" onclick="location.href='allTask.html'">小组作业</p>
            <p class="navP navP2" style="" onclick="location.href='allProj.html'">项目报名</p>
            <p class="navP navP2" style="" onclick="location.href='gradeRecord.html'">查看积分</p>
            <p class="navP navP2" style="" onclick="location.href='weekTask.html'">周计划</p>
        </div>
    <p class="navP" style="" onclick="location.href='bachelorBlock.html'">研究生模块</p>
    <p class="navP" style="" onclick="location.href='activityIng.html'">活动组织</p>
    <p class="navP" style="" onclick="location.href='fundProj.html'">项目展示</p>

    <p class="navP" style="" onclick="location.href='bookAll.html'">图书管理</p>

    <p class="navP" style="" onclick="location.href='goodMng.html'">物资管理</p>
    `;
    var TL=`
    <p class="navP" style="" onclick="location.href='allTaskTL.html'">所有作业</p>
    <p class="navP" style="" onclick="location.href='submitTL.html'">已提交</p>
    <p class="navP" style="" onclick="location.href='publicTL.html'">发布作业</p>
    `;
    var PM=`
    <p class="navP" style="" onclick="location.href='myProjPM.html'">我的项目</p>
    <p class="navP" style="" onclick="location.href='ProjRecordPM.html'">报名记录</p>
    `;
    var currentRole=getCookie('role');
    //alert(currentRole);
    switch (currentRole){//判断当前身份以加载不同的侧边栏菜单
        case '1':
            $('#navigation').append(SU);
            break;
        case '2':
            $('#navigation').append(AD);
            break;
        case '3':
            $('#navigation').append(UDBC);
            break;
        case '4':
            $('#navigation').append(PM);
            break;
        case '5':
            $('#navigation').append(TL);
            break;
        case '6':
            $('#navigation').append(UDBC);
            break;
    }
    
});

function switchOpenDaily(){
    dailyB=!dailyB;
    if(dailyB){//请求打开
        if(dailyB&&underB){//两个同时开启，修改另一个的值，关闭另一个
            underB=false;
            $('#undergBlock').css("display","none");
        }
        $('#dailyBlock').css("display","block");
    }else{//关闭：直接关闭自己
        $('#dailyBlock').css("display","none");
    }
}

function switchOpenUderB(){
    underB=!underB;
    if(underB){//请求打开
        if(dailyB&&underB){//两个同时开启，修改另一个的值，关闭另一个
            dailyB=false;
            $('#dailyBlock').css("display","none");
        }
        $('#undergBlock').css("display","block");
    }else{
        $('#undergBlock').css("display","none");
    }
}

