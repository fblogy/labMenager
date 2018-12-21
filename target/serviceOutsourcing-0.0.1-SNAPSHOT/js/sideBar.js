$(function(){
    show_navigation();
});
function show_navigation(){
    let status = $("#navigation").data("isShow");
    status = status == undefined ? true : status;
    if(status){
        $("#navigation").animate({
            width: "0px",
            'min-width': '0px',
            'margin-left': '-100%'
        },{duration: 800},function(){
            $("#navigation").css("display","none");
        });
    }
    else
    {
        $("#navigation").animate({
            width: "230px",
            'min-width': '230px',
            'margin-left': '0px'
        },{duration: 800},function(){
            $("#navigation").css("display","flex");
        });
    }
    status = !status;
    $("#navigation").data("isShow",status);
}