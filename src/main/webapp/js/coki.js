function setCookie(key,value,exp){
    var ddate=new Date();
    ddate.setDate(ddate.getDate()+exp);
    document.cookie=encodeURIComponent(key)+'='+encodeURIComponent(value)+';expires='+ddate+';path=/';
    //alert(document.cookie);
}
function getCookie(key){
    var arrStr=decodeURIComponent(document.cookie).split('; ');
    //alert(arrStr.length);
    var flag=0;//δ�ҵ�
    for(var i=0;i<arrStr.length;i++){
        
        var arr=arrStr[i].split('=');
        //alert(arr[0]);
        if(arr[0]==key){
            flag=1;
            return arr[1];
        }//�Ҳ�����return undefined;
    }
    if(flag==0){
        return "";
    }
    //alert(arrStr);
    //alert(arrStr[0]);
}
function removeCookie(key){
    setCookie(key,null,-1);
}