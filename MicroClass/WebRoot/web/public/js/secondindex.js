$(document).ready(function () {
    $("#lk_header .navbar-nav").children("li").eq(1).click(function () {
        $(location).attr("href","secondindex.html")
    });
    $("#lk_header .navbar-nav").children("li").eq(2).click(function () {
        $(location).attr("href","thirdindex.html")
    });
    $("#lk_header .navbar-nav").children("li").eq(3).click(function () {
        $(location).attr("href","fifthindex.html")
    });
    $("#lk_header .navbar-nav").children("li").eq(4).click(function () {
        $(location).attr("href","sixindex.html")
    });
    $("#lk_header .navbar-nav .fourthindex").click(function () {
        $(location).attr("href","fourthindex.html")
    })
})