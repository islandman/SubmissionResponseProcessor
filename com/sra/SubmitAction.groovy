package com.agcocorp.fuse.features.api.TrimbleAdapter.parser

/**
 * Created by cjames on 8/15/15.
 */
class SubmitAction {
    String  responseStatus
    String  accession
    SubmitAction(responseStatus,accession) {
        this.responseStatus = responseStatus
        this.accession =accession
    }
    SubmitAction(){}
    def String toString() {
        def result = "responseStatus : "   + this.responseStatus + "\n" +
                     "accession      :  "  + this.accession +"\n"
        result
    }

    static main(String[]  args ) {

       def submit =  new SubmitAction(responseStatus:'test',accession:'test')
        println submit.toString()
    }
}
