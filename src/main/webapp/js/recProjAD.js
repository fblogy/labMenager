var pageSize=11;
var pmStateArray=['<span style="color:gray">待审核</span>','<span style="color:green">通过</span>','<span style="color:red">未通过</span>'];
$(document).ready(function(){
    $.ajax({
        url:'getAllApplyList',
        data:{
            "pageNum":"1",
            "pageSize":pageSize
        },
        type:'POST',
        success:function(data){
           // alert(data);
            //$('td').html('');
            var jsonobj=JSON.parse(data);
            var jsonpages=jsonobj.pages;
            var jsonrealRowNum=jsonobj.realRowNum;
            var jsonrows=jsonobj.rows;
            for(var i=0;i<jsonrealRowNum;i++){
                var getTRi=$('tobody').children('tr').eq(i);
                alert(($('tobody').children('tr').eq(i)).children('td').eq(0).html());
                $(getTRi).children('td').eq(0).html('6563');
                $(getTRi).children('td').eq(1).html(jsonrows[i].projectApplyName);
                $(getTRi).children('td').eq(2).html(jsonrows[i].pmReason);
                $(getTRi).children('td').eq(3).html(jsonrows[i].pmTimeStr);
                $(getTRi).children('td').eq(4).html(pmStateArray[jsonrows[i].pmStatus]);
               // alert(jsonrows[i].projectId+jsonrows[i].projectApplyName+jsonrows[i].pmReason+jsonrows[i].pmTimeStr+pmStateArray[jsonrows[i].pmStatus])
            }
        },
        error:function(){

        }
    })
})