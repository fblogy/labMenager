var q=document.createElement('script');
q.setAttribute('type','text/javascript');
q.setAttribute('src','./js/coki.js');
document.body.appendChild(q);

var pageSize=11;//每页11条
var swiID=true;
var swiState=false;
var searchCont="";



function bookSure(){//申请图书
    var bookName=$('#bookName').val();
    var bookAuthor=$('#bookAuthor').val();
    var bookISBN=$('#bookISBN').val();
    var bookHome=$('#bookHome').val();
    var bookReason=$('#bookReason').val();
    if((bookName=='')||(bookAuthor=='')||(bookISBN=='')||(bookHome=='')||(bookReason=='')){
        alert('输入不能为空！');
    }else{
        //alert(getCookie('userAccount'));
        $.ajax({
            url:'sysBookInsertNewBook',
            type:'POST',
            data:{
                "isbn":bookISBN,
                "name":bookName,
                "writer":bookAuthor,
                "pub":bookHome,
                "mark":bookReason,
                "buyer":getCookie('userAccount'),
                "status":"-3"
            },
            success:function(data){
                if(typeof(JSON.parse(data).success)==undefined){}
                else{
                    alert(JSON.parse(data).success);
                }
                
                if(typeof(JSON.parse(data).error)=="undefined"){}
                else{
                    alert(JSON.parse(data).error);
                }
               
                window.location.reload();
            },
            error:function(){

            }

        })
    }
}

$(document).ready(function(){
    $.ajax({
        url:"sysBookSelect",
        type:'POST',
        data:{
            "PageSize":pageSize,
            "start":1,
            "sortFlag":0   //编号正序
        },
        success:function(data){
            if(typeof(JSON.parse(data).error)=="undefined"){}
            else{
                alert(JSON.parse(data).error)
            }

            if(typeof(JSON.parse(data).count)=="undefined"){}
            else{
                var jsonCount=JSON.parse(data).count;
                var jsonAllBook=JSON.parse(data).allbook;
                var jsonAllBookLength=jsonAllBook.length;
                for(var i=0;i<jsonAllBookLength;i++){
                    if(jsonAllBook[i].bookStatus=="1"){//free
                        $('tbody').append(`
                    <tr>
                        <td>${jsonAllBook[i].id}</td>
                        <td>${jsonAllBook[i].isbn}</td>
                        <td>${jsonAllBook[i].bookName}</td>
                        <td>${jsonAllBook[i].bookWriter}</td>
                        <td>${jsonAllBook[i].bookPub}</td>
                        <td>${jsonAllBook[i].bookMark}</td>
                        <td style="background-color:#C93756;color:white;cursor:pointer" onclick="borrowBook(${jsonAllBook[i].id})">借书</td>
                    </tr>                    
                    `);
                    }else if(jsonAllBook[i].bookStatus=="0"){//borrowed
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].isbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td>${jsonAllBook[i].bookBorrower}</td>
                        </tr>                    
                        `);
                    }

                    
                }
                for (var j=1;j<=pageSize-jsonAllBookLength;j++){
                    $('tbody').append(`
                                    <tr>
										<td>&#12288;</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
                    `);
                }

                //  ====================================
                //  ------------页码--------------------
                //  ====================================

                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">上页</a></li>`);
                for(var i=1;i<=jsonCount;i++){
                    if(i==1){
                        $('#pageBar').append(`<li class="page-item active"><a class="page-link" href="#" onclick="turnPage(this)">1</a></li>`);
                    }else{
                        $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#" onclick="turnPage(this)">${i}</a></li>`);
                    }
                }
                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">下页</a></li>`);

            }
        },
        error:function(){

        }
    })
})

function turnPage(my){
    if(swiID){//true
        temp=0;
    }else{
        temp=1;
    }
    var mypage=my.innerHTML;
    //alert(mypage);
    $('tbody').children().remove();


    // ---------------------------
    $('.page-item').removeClass('active');
    $(my).parent('.page-item').addClass('active');

    // ==================================
    // -----------copy-------------------
    // ==================================

    $.ajax({
        url:"sysBookSelect",
        type:'POST',
        data:{
            "PageSize":pageSize,
            "start":mypage,
            "sortFlag":temp   //编号正序
        },
        success:function(data){
            if(typeof(JSON.parse(data).error)=="undefined"){}
            else{
                alert(JSON.parse(data).error)
            }

            if(typeof(JSON.parse(data).count)=="undefined"){}
            else{
                var jsonCount=JSON.parse(data).count;
                var jsonAllBook=JSON.parse(data).allbook;
                var jsonAllBookLength=jsonAllBook.length;
                for(var i=0;i<jsonAllBookLength;i++){
                    if(jsonAllBook[i].bookStatus=="1"){//free
                        $('tbody').append(`
                    <tr>
                        <td>${jsonAllBook[i].id}</td>
                        <td>${jsonAllBook[i].isbn}</td>
                        <td>${jsonAllBook[i].bookName}</td>
                        <td>${jsonAllBook[i].bookWriter}</td>
                        <td>${jsonAllBook[i].bookPub}</td>
                        <td>${jsonAllBook[i].bookMark}</td>
                        <td style="background-color:#C93756;color:white;cursor:pointer" onclick="borrowBook(${jsonAllBook[i].id})">借书</td>
                    </tr>                    
                    `);
                    }else if(jsonAllBook[i].bookStatus=="0"){//borrowed
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].isbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td>${jsonAllBook[i].bookBorrower}</td>
                        </tr>                    
                        `);
                    }

                    
                }
                for (var j=1;j<=pageSize-jsonAllBookLength;j++){
                    $('tbody').append(`
                                    <tr>
										<td>&#12288;</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
                    `);
                }

                //  ====================================
                //  ------------页码--------------------
                //  ====================================

                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">上页</a></li>`);
                // for(var i=1;i<=jsonCount;i++){
                //     if(i==1){
                //         $('#pageBar').append(`<li class="page-item active"><a class="page-link" href="#" onclick="turnPage(this)">1</a></li>`);
                //     }else{
                //         $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#" onclick="turnPage(this)">${i}</a></li>`);
                //     }
                // }
                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">下页</a></li>`);

            }
        },
        error:function(){

        }
    })

}

function borrowBook(bookid){
    //alert(bookid+getCookie('userAccount'));
    $.ajax({
        url:'sysBookUpdate',
        type:'POST',
        data:{
            "id":bookid,
            "status":0,
            "account":getCookie('userAccount')
        },
        success:function(data){
            if(typeof(JSON.parse(data).error)=="undefined"){}
            else{
                alert(JSON.parse(data).error);
            }

            if(typeof(JSON.parse(data).success)=="undefined"){}
            else{
                alert(JSON.parse(data).success);
                window.location.reload();
            }
        },
        error:function(){

        }
    })
}

$('#searchText').keydown(function(e){
    if(e.keyCode==13){
        
        var searchText=$('#searchText').val();
        searchCont=searchText;

        //alert(searchText+pageSize);
        $.ajax({
            url:'sysBookSelectPart',
            type:'POST',
            data:{
                "word":searchText,
                "PageSize":pageSize,
                "start":1,
                "sortFlag":0
            },
            success:function(data){
                //alert(data);
                if(typeof(JSON.parse(data).error)=="undefined"){}
                else{
                    alert(JSON.parse(data).error);
                }
    
                if(typeof(JSON.parse(data).count)=="undefined"){}
                else{
                    $('tbody').children().remove();
                    $('#pageBar').children().remove();
                    // ====================
                    // ---------copy-------
                    // ====================
                    var jsonCount=JSON.parse(data).count;
                    var jsonAllBook=JSON.parse(data).Book;
                    var jsonAllBookLength=jsonAllBook.length;
                    for(var i=0;i<jsonAllBookLength;i++){
                        if(jsonAllBook[i].bookStatus=="1"){//free
                            $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].isbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td style="background-color:#C93756;color:white;cursor:pointer" onclick="borrowBook(${jsonAllBook[i].id})">借书</td>
                        </tr>                    
                        `);
                        }else if(jsonAllBook[i].bookStatus=="0"){//borrowed
                            $('tbody').append(`
                            <tr>
                                <td>${jsonAllBook[i].id}</td>
                                <td>${jsonAllBook[i].isbn}</td>
                                <td>${jsonAllBook[i].bookName}</td>
                                <td>${jsonAllBook[i].bookWriter}</td>
                                <td>${jsonAllBook[i].bookPub}</td>
                                <td>${jsonAllBook[i].bookMark}</td>
                                <td>${jsonAllBook[i].bookBorrower}</td>
                            </tr>                    
                            `);
                        }
    
                        
                    }
                    for (var j=1;j<=pageSize-jsonAllBookLength;j++){
                        $('tbody').append(`
                                        <tr>
                                            <td>&#12288;</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                        `);
                    }
    
                    //  ====================================
                    //  ------------页码--------------------
                    //  ====================================
    
                    // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">上页</a></li>`);
                    for(var i=1;i<=jsonCount;i++){
                        if(i==1){
                            $('#pageBar').append(`<li class="page-item active"><a class="page-link" href="#" onclick="turnPageS(this,${searchText})">1</a></li>`);
                        }else{
                            $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#" onclick="turnPageS(this,${searchText})">${i}</a></li>`);
                        }
                    }
                    // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">下页</a></li>`);
    
                }
            },
            error:function(){
                //alert(data);
                
            }
        })
    }
})

function turnPageS(my,mysearch){
    if(swiID){//true
        temp=0;
    }else{
        temp=1;
    }
    //alert(mysearch)
    if(mysearch==undefined){
        //alert('mysearch is undefined')
        mysearch="";
    }
    var mypage=my.innerHTML;
    //alert(mypage);
    $('tbody').children().remove();
    // ---------------------------
    $('.page-item').removeClass('active');
    
    $(my).parent('.page-item').addClass('active');

    // ==================================
    // -----------copy-------------------
    // ==================================

    $.ajax({
        url:"sysBookSelectPart",
        type:'POST',
        data:{
                "word":mysearch,
                "PageSize":pageSize,
                "start":mypage,
                "sortFlag":temp
        },
        success:function(data){
            if(typeof(JSON.parse(data).error)=="undefined"){}
            else{
                alert(JSON.parse(data).error)
            }

            if(typeof(JSON.parse(data).count)=="undefined"){}
            else{
                var jsonCount=JSON.parse(data).count;
                var jsonAllBook=JSON.parse(data).Book;
                var jsonAllBookLength=jsonAllBook.length;
                for(var i=0;i<jsonAllBookLength;i++){
                    if(jsonAllBook[i].bookStatus=="1"){//free
                        $('tbody').append(`
                    <tr>
                        <td>${jsonAllBook[i].id}</td>
                        <td>${jsonAllBook[i].isbn}</td>
                        <td>${jsonAllBook[i].bookName}</td>
                        <td>${jsonAllBook[i].bookWriter}</td>
                        <td>${jsonAllBook[i].bookPub}</td>
                        <td>${jsonAllBook[i].bookMark}</td>
                        <td style="background-color:#C93756;color:white;cursor:pointer" onclick="borrowBook(${jsonAllBook[i].id})">借书</td>
                    </tr>                    
                    `);
                    }else if(jsonAllBook[i].bookStatus=="0"){//borrowed
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].isbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td>${jsonAllBook[i].bookBorrower}</td>
                        </tr>                    
                        `);
                    }

                    
                }
                for (var j=1;j<=pageSize-jsonAllBookLength;j++){
                    $('tbody').append(`
                                    <tr>
										<td>&#12288;</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
                    `);
                }

                //  ====================================
                //  ------------页码--------------------
                //  ====================================

                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">上页</a></li>`);
                // for(var i=1;i<=jsonCount;i++){
                //     if(i==1){
                //         $('#pageBar').append(`<li class="page-item active"><a class="page-link" href="#" onclick="turnPage(this)">1</a></li>`);
                //     }else{
                //         $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#" onclick="turnPage(this)">${i}</a></li>`);
                //     }
                // }
                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">下页</a></li>`);

            }
        },
        error:function(){

        }
    })

}



function switchID(){
    $('tbody').children().remove();
    swiID=!swiID;//取反，第一次为正
    var temp//0正1逆
    if(swiID){//true
        temp=0;
    }else{
        temp=1;
    }
    $.ajax({
        url:"sysBookSelectPart",
        type:'POST',
        data:{
                "word":searchCont,
                "PageSize":pageSize,
                "start":1,
                "sortFlag":temp
        },
        success:function(data){
            if(typeof(JSON.parse(data).error)=="undefined"){}
            else{
                alert(JSON.parse(data).error)
            }

            if(typeof(JSON.parse(data).count)=="undefined"){}
            else{
                var jsonCount=JSON.parse(data).count;
                var jsonAllBook=JSON.parse(data).Book;
                var jsonAllBookLength=jsonAllBook.length;
                for(var i=0;i<jsonAllBookLength;i++){
                    if(jsonAllBook[i].bookStatus=="1"){//free
                        $('tbody').append(`
                    <tr>
                        <td>${jsonAllBook[i].id}</td>
                        <td>${jsonAllBook[i].isbn}</td>
                        <td>${jsonAllBook[i].bookName}</td>
                        <td>${jsonAllBook[i].bookWriter}</td>
                        <td>${jsonAllBook[i].bookPub}</td>
                        <td>${jsonAllBook[i].bookMark}</td>
                        <td style="background-color:#C93756;color:white;cursor:pointer" onclick="borrowBook(${jsonAllBook[i].id})">借书</td>
                    </tr>                    
                    `);
                    }else if(jsonAllBook[i].bookStatus=="0"){//borrowed
                        $('tbody').append(`
                        <tr>
                            <td>${jsonAllBook[i].id}</td>
                            <td>${jsonAllBook[i].isbn}</td>
                            <td>${jsonAllBook[i].bookName}</td>
                            <td>${jsonAllBook[i].bookWriter}</td>
                            <td>${jsonAllBook[i].bookPub}</td>
                            <td>${jsonAllBook[i].bookMark}</td>
                            <td>${jsonAllBook[i].bookBorrower}</td>
                        </tr>                    
                        `);
                    }

                    
                }
                for (var j=1;j<=pageSize-jsonAllBookLength;j++){
                    $('tbody').append(`
                                    <tr>
										<td>&#12288;</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
                    `);
                }

                //  ====================================
                //  ------------页码--------------------
                //  ====================================

                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">上页</a></li>`);
                // for(var i=1;i<=jsonCount;i++){
                //     if(i==1){
                //         $('#pageBar').append(`<li class="page-item active"><a class="page-link" href="#" onclick="turnPage(this)">1</a></li>`);
                //     }else{
                //         $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#" onclick="turnPage(this)">${i}</a></li>`);
                //     }
                // }
                // $('#pageBar').append(`<li class="page-item"><a class="page-link" href="#">下页</a></li>`);

            }
        },
        error:function(){

        }
    })
}
