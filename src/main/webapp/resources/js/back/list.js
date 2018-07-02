/**
 * 批量删除
 */
function deleteBatch(basePath) {
    $("#mainForm").attr("action",basePath + "DeleteBatch.action");
    $("#mainForm").submit();
}

/**
 * 修改当前页码，调用后台重新查询
 * @param currentPage
 */
function changeCurrentPage(currentPage) {
    $("#currentPage").val(currentPage);
    $("#mainForm").submit();
}