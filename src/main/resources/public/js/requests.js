function getBookRequestBody() {
    var body = {
        type: 'book',
        identifier: getInputValue('identifier'),
        attributes: [
            {key: "author", value: getInputValue('author')},
            {key: "title", value: getInputValue('title')},
            {key: "publisher", value:getInputValue('publisher')},
            {key: "year", value: getInputValue('year')}
        ]
    };
    return JSON.stringify(body);
}

function getInproceedingsRequestBody() {
    var body = {
        type: 'inproceedings',
        identifier: $('#identifier').val(),
        attributes: [
            {key: "author", value: $('#author').val()},
            {key: "title", value: $('#title').val()},
            {key: "booktitle", value: $('#booktitle').val()},
            {key: "year", value: $('#year').val()}
        ]
    };
    return JSON.stringify(body);
}

function getArticleRequestBody() {
    var body = {
        type: 'article',
        identifier: getInputValue('identifier'),
        attributes: [
            {key: "author", value: getInputValue('author')},
            {key: "title", value: getInputValue('title')},
            {key: "volume", value: getInputValue('volume')},
            {key: "year", value: getInputValue('year')},
            {key: "journal", value: getInputValue('journal')}
        ]
    };
    return JSON.stringify(body);
}

function getInputValue(id) {
    return $('#' + id).val();
}
