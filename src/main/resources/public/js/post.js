function submitBookForm() {
    var body = getBookRequestBody();
    POST(body);
}

function submitArticleForm() {
    var body = getArticleRequestBody();
    POST(body);
}

function submitInproceedingsForm() {
    var formData = getInproceedingsRequestBody();
    POST(formData);
}

function POST(body) {
    $.ajax({
        type: 'POST',
        url: '/reference',
        data: body,
        contentType: 'application/json',
        error: function(error) {console.error('Failed with error: ' + error)}
    });
}
