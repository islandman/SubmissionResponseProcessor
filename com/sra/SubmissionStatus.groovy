package com.agcocorp.fuse.features.api.TrimbleAdapter.parser

/**
 * Created by cjames on 8/15/15.
 */
class SubmissionStatus {
    def status
    def study
    def actions = new ArrayList<SubmitAction>()
    SubmissionStatus(status) {
        this.status = status
    }
    def String toString() {
        def result = "status : " + this.status + "\n"
                     "study  : " + this.study +"\n"
        this.actions.each { action ->

            result += action.toString()
        }
        result
    }


}