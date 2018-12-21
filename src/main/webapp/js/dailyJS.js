var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);

var a=document.createElement('script');
a.setAttribute('type','text/javascript');
a.setAttribute('src','./js/xlsx.js');
document.body.appendChild(a);


// var check21;//修改签到
// var check2c;//修改值日研究生
// var check2a;//修改卫生负责人
// var check20;//查看签到表//无需验证000
// var check29;//查看w卫生负责人//无需验证000
// var check2b;//查看研究生值日表//无需验证000

$(window).on('load',function(){//初始化后设置一次
    
    // $.ajax({//获取签到前3
    //     url:'getTopSignCountByYearAndMonth',
    //     data:{
    //     },
    //     type:'POST',
    //     success:function(data){
    //         alert('签到前3等待数据返回');
    //     },
    //     error:function(code){
    //         //alert('e');
    //     }
    // })
    $.ajax({//签到前3
        url:'getTopSignCountByYearAndMonth',
        data:{

        },
        type:'POST',
        success:function(data){
            var jsonobj=JSON.parse(data);
            var jsontotal=jsonobj.total;
            var jsonrows=jsonobj.rows;
            $('#tableFirst').children('tr').remove();
            for(var i=0;i<jsontotal;i++){
                $('#tableFirst').append('<tr><td>'+jsonrows[i].userName+'</td><td>'+jsonrows[i].signCount+'</td></tr>')
            }
            $('#signTitle').html(jsonobj.time);
        }
    })

    $.ajax({//值日研究生
        url:'getGraduateDutyList',
        data:{},
        type:'POST',
        success:function(data){
            //alert(data);
            var jsonobj=JSON.parse(data);
            var jsontotal=jsonobj.total;
            var jsonrows=jsonobj.rows;
            var transWeekday=['x','星期一','星期二','星期三','星期四','星期五','星期六','星期日',]
            $('#tableSecond').children('tr').remove();
            for(var i=1;i<=jsontotal;i++){
                $('#tableSecond').append('<tr><td>'+transWeekday[jsonrows[i-1].graduateDutyOrderonweek]+'</td><td>'+jsonrows[i-1].graduateDutyName+'</td><td>'+jsonrows[i-1].graduateDutyPhone+'</td></tr>')
            }
        }

    })

    $.ajax({//卫生负责人
        url:'getSysHealthHeadList',
        data:{},
        type:'POST',
        success:function(data){
            var jsonobj=JSON.parse(data);
            var jsontotal=jsonobj.total;
            var jsonrows=jsonobj.rows;
            $('#tableThird').children('tr').remove();
            for(var i=1;i<=jsontotal;i++){
                $('#tableThird').append('<tr><td>第'+jsonrows[i-1].healthWeekOrder+'周</td><td>'+jsonrows[i-1].healthName2+' '+jsonrows[i-1].healthName+'</td></tr>');
            }
        }
    })



    ///////////////////////////////////////
    // $.ajax({//查看签到前三名
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"20"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check20=jsonobj.privilege;
    //         //alert(check20+'查看签到');
    //     }
    // })
    // $.ajax({//查看卫生负责人
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"29"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check29=jsonobj.privilege;
    //         //alert(check29+'查看卫生负责人');
    //     }
    // })
    // $.ajax({//查看研究生值日表
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"2b"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check2b=jsonobj.privilege;
    //         //alert(check2b+'查看研究生值日表');
    //     }
    // })

    //////////////////////////////////////////////
    // $.ajax({//修改签到前三名
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"21"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check21=jsonobj.privilege;
    //         //alert(check21+'修改签到');
    //     }
    // })
    // $.ajax({//修改z值日研究生
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"2c"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check2c=jsonobj.privilege;
    //         //alert(check2c+'修改值日研究生');
    //     }
    // })
    // $.ajax({//修改卫生负责人
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"2a"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check2a=jsonobj.privilege;
    //         //alert(check2a+'修改卫生负责人');
    //     }
    // })


})

function setInit(myself){//切换身份再设置一次
    //alert($(myself).attr('data-role'));
    // $.ajax({//查看签到前三名
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"20"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check20=jsonobj.privilege;
    //         //alert(check20+'查看签到');
    //     }
    // })
    // $.ajax({//查看卫生负责人
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"29"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check29=jsonobj.privilege;
    //         //alert(check29+'查看卫生负责人');
    //     }
    // })
    // $.ajax({//查看研究生值日表
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"2b"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check2b=jsonobj.privilege;
    //         //alert(check2b+'查看研究生值日表');
    //     }
    // })
    /////////////////////////////////////////////////
    // $.ajax({//修改签到前三名
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"21"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check21=jsonobj.privilege;
    //         //alert(check21+'修改签到');
    //     }
    // })
    // $.ajax({//修改z值日研究生
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"2c"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check2c=jsonobj.privilege;
    //         //alert(check2c+'修改值日研究生');
    //     }
    // })
    // $.ajax({//修改卫生负责人
    //     url:'privilege',
    //     data:{
    //         "role":getCookie('cuRole'),
    //         "option":"2a"
    //     },
    //     type:'POST',
    //     success:function(data){
    //         var jsonobj=JSON.parse(data);
    //         //console.log(checkRight);
    //         check2a=jsonobj.privilege;
    //         //alert(check2a+'修改卫生负责人');
    //     }
    // })

}

function tFclick(){
    //if(check21){
        $('#tableFirstFile').click();
    //}else{
    //    alert('当前身份无此操作权限!');
    //}
}
function tSclick(){
    //if(check2c){
        $('#tableSecondFile').click();
    //}else{
    //    alert('当前身份无此操作权限!');
    //}
}
function tTclick(){
    //if(check2a){
        $('#tableThirdFile').click();
    //}else{
    //    alert('当前身份无此操作权限!');
    //}
}

function createObj(signId,signTime){//签到
    this.signId=signId;
    this.signTime=signTime;
}
function createObj2c(dayWeek,yjsId,yjsPhone){//值日研究生
    this.dayWeek=dayWeek;
    this.yjsId=yjsId;
    this.yjsPhone=yjsPhone;
}
function createObj2a(principal1,principal2,weekNum){//卫生负责人
    
    this.principal1=principal1;
    this.principal2=principal2;
    this.weekNum=weekNum;
}

$('#tableFirstFile').change(function(e){
    var files = e.target.files;

    var fileReader = new FileReader();
    fileReader.onload = function(ev) {
        try {
            var data = ev.target.result,
                workbook = XLSX.read(data, {
                    type: 'binary'
                }), // 以二进制流方式读取得到整份excel表格对象
                persons = []; // 存储获取到的数据
        } catch (e) {
            alert('文件类型不正确');
            return;
        }

        // 表格的表格范围，可用于判断表头是否数量是否正确
        var fromTo = '';
        // 遍历每张表读取
        for (var sheet in workbook.Sheets) {
            if (workbook.Sheets.hasOwnProperty(sheet)) {
                fromTo = workbook.Sheets[sheet]['!ref'];
                //console.log(fromTo);
                persons = persons.concat(XLSX.utils.sheet_to_json(workbook.Sheets[sheet]));
                break; // 如果只取第一张表，就取消注释这行
            }
        }
        //console.log(persons);////////////////////////////
        var getFileName21Arr=$('#tableFirstFile').val().split('\\');//路径字符数组
        var getFileName21Length=getFileName21Arr.length;//路径字符数组长度
        var getFileName21=getFileName21Arr[getFileName21Length-1];//文件名
        //console.log(getFileName21);//////////////////
        var getData21Arr=[];
        var confirm21=confirm('是否确认上传'+getFileName21+'?');
        if(confirm21){//确认，向后台发送
            for(var i=0;i<persons.length;i++){
                temp=new createObj(persons[i].stuId,persons[i].signPoint);
                getData21Arr[i]=temp;
            }
            //alert(JSON.stringify(getData21Arr));
            $.ajax({
                url:'insertSignRecord',
                type:'POST',
                data:{
                    "rows":JSON.stringify(getData21Arr)
                },
                success:function(data){
                    alert(JSON.parse(data).msg);
                    location.reload();
                }
            })


        }else{//取消，中止上传
            alert('上传已取消');
        }



    };

    // 以二进制方式打开文件
    fileReader.readAsBinaryString(files[0]);

    //console.log($('#tableFirstFile').val());//////////////////////路径
    // var getFileName21Arr=$('#tableFirstFile').val().split('\\');//路径字符数组
    // var getFileName21Length=getFileName21Arr.length;//路径字符数组长度
    // var getFileName21=getFileName21Arr[getFileName21Length-1];//文件名
    // console.log(getFileName21);//////////////////
    // var getData21Arr=[];
    // var confirm21=confirm('是否确认上传'+getFileName21+'?');
    // if(confirm21){//确认，向后台发送
    //     for(var i=0;i<persons.length;i++){
    //         temp=new createObj(persons[i].stuId,persons[i].signPoint);
    //         getData21Arr.push(temp);
    //     }
    //     console.log(getData21Arr);
    // }else{//取消，中止上传
    //     alert('上传已取消');
    // }

});
   

$('#tableSecondFile').change(function(e){
    var files = e.target.files;

    var fileReader = new FileReader();
    fileReader.onload = function(ev) {
        try {
            var data = ev.target.result,
                workbook = XLSX.read(data, {
                    type: 'binary'
                }), // 以二进制流方式读取得到整份excel表格对象
                persons = []; // 存储获取到的数据
        } catch (e) {
            alert('文件类型不正确');
            return;
        }

        // 表格的表格范围，可用于判断表头是否数量是否正确
        var fromTo = '';
        // 遍历每张表读取
        for (var sheet in workbook.Sheets) {
            if (workbook.Sheets.hasOwnProperty(sheet)) {
                fromTo = workbook.Sheets[sheet]['!ref'];
                //console.log(fromTo);
                persons = persons.concat(XLSX.utils.sheet_to_json(workbook.Sheets[sheet]));
                break; // 如果只取第一张表，就取消注释这行
            }
        }
        //console.log(persons);////////////////////////////
        var getFileName2cArr=$('#tableSecondFile').val().split('\\');//路径字符数组
        var getFileName2cLength=getFileName2cArr.length;//路径字符数组长度
        var getFileName2c=getFileName2cArr[getFileName2cLength-1];//文件名
        //console.log(getFileName21);//////////////////
        var getData2cArr=[];
        var confirm2c=confirm('是否确认上传'+getFileName2c+'?');
        if(confirm2c){//确认，向后台发送
            console.log(persons);
            for(var i=0;i<persons.length;i++){
                temp=new createObj2c(persons[i].dayWeek,persons[i].yjsId,persons[i].yjsPhone);
                getData2cArr[i]=temp;
            }
            //alert(JSON.stringify(getData2cArr));
            $.ajax({
                url:'updateGraduateDutyList',
                type:'POST',
                data:{
                    "rows":JSON.stringify(getData2cArr)
                },
                success:function(data){
                    alert(JSON.parse(data).msg);
                    location.reload();
                }
            })
        }else{//取消，中止上传
            alert('上传已取消');
        }



    };

    // 以二进制方式打开文件
    fileReader.readAsBinaryString(files[0]);

    //console.log($('#tableFirstFile').val());//////////////////////路径
    // var getFileName21Arr=$('#tableFirstFile').val().split('\\');//路径字符数组
    // var getFileName21Length=getFileName21Arr.length;//路径字符数组长度
    // var getFileName21=getFileName21Arr[getFileName21Length-1];//文件名
    // console.log(getFileName21);//////////////////
    // var getData21Arr=[];
    // var confirm21=confirm('是否确认上传'+getFileName21+'?');
    // if(confirm21){//确认，向后台发送
    //     for(var i=0;i<persons.length;i++){
    //         temp=new createObj(persons[i].stuId,persons[i].signPoint);
    //         getData21Arr.push(temp);
    //     }
    //     console.log(getData21Arr);
    // }else{//取消，中止上传
    //     alert('上传已取消');
    // }

});

$('#tableThirdFile').change(function(e){
    var files = e.target.files;

    var fileReader = new FileReader();
    fileReader.onload = function(ev) {
        try {
            var data = ev.target.result,
                workbook = XLSX.read(data, {
                    type: 'binary'
                }), // 以二进制流方式读取得到整份excel表格对象
                persons = []; // 存储获取到的数据
        } catch (e) {
            alert('文件类型不正确');
            return;
        }

        // 表格的表格范围，可用于判断表头是否数量是否正确
        var fromTo = '';
        // 遍历每张表读取
        for (var sheet in workbook.Sheets) {
            if (workbook.Sheets.hasOwnProperty(sheet)) {
                fromTo = workbook.Sheets[sheet]['!ref'];
                //console.log(fromTo);
                persons = persons.concat(XLSX.utils.sheet_to_json(workbook.Sheets[sheet]));
                break; // 如果只取第一张表，就取消注释这行
            }
        }
        //console.log(persons);////////////////////////////
        var getFileName2aArr=$('#tableThirdFile').val().split('\\');//路径字符数组
        var getFileName2aLength=getFileName2aArr.length;//路径字符数组长度
        var getFileName2a=getFileName2aArr[getFileName2aLength-1];//文件名
        //console.log(getFileName21);//////////////////
        var getData2aArr=[];
        var confirm2a=confirm('是否确认上传'+getFileName2a+'?');
        if(confirm2a){//确认，向后台发送
            console.log(persons);
            for(var i=0;i<persons.length;i++){
                temp=new createObj2a(persons[i].principal1,persons[i].principal2,persons[i].weekNum);
                getData2aArr[i]=temp;
            }
            //alert(JSON.stringify(getData2aArr));
            $.ajax({
                url:'insertHealthHeadList',
                type:'POST',
                data:{
                    "rows":JSON.stringify(getData2aArr)
                },
                success:function(data){
                    alert(JSON.parse(data).msg);
                    location.reload();
                }
            })
        }else{//取消，中止上传
            alert('上传已取消');
        }



    };

    // 以二进制方式打开文件
    fileReader.readAsBinaryString(files[0]);

    //console.log($('#tableFirstFile').val());//////////////////////路径
    // var getFileName21Arr=$('#tableFirstFile').val().split('\\');//路径字符数组
    // var getFileName21Length=getFileName21Arr.length;//路径字符数组长度
    // var getFileName21=getFileName21Arr[getFileName21Length-1];//文件名
    // console.log(getFileName21);//////////////////
    // var getData21Arr=[];
    // var confirm21=confirm('是否确认上传'+getFileName21+'?');
    // if(confirm21){//确认，向后台发送
    //     for(var i=0;i<persons.length;i++){
    //         temp=new createObj(persons[i].stuId,persons[i].signPoint);
    //         getData21Arr.push(temp);
    //     }
    //     console.log(getData21Arr);
    // }else{//取消，中止上传
    //     alert('上传已取消');
    // }

});

$(document).ready(function(){
    var currentRole=getCookie('role');
    if((currentRole!='1')&&(currentRole!='2')){
        //alert(currentRole);
        $('#tableFirstBtn').hide();
        $('#tableSecondBtn').hide();
        $('#tableThirdBtn').hide();
    }
})
