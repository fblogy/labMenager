
function show_navigation(){
    let status = $("#navigation").data("isShow");
    status = status == undefined ? true : status;
    if(status){
        $("#navigation").animate({
            width: "0px",
            'min-width': '0px',
            'margin-left': '-1%'
        },{duration: 500},function(){
            $("#navigation").css("display","none");
        });
    }
    else
    {
        $("#navigation").animate({
            width: "235px",
            'min-width': '235px',
            'margin-left': '0px'
        },{duration: 500},function(){
            $("#navigation").css("display","flex");
        });
    }
    status = !status;
    $("#navigation").data("isShow",status);
}