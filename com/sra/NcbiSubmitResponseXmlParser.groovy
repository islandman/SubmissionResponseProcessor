package com.agcocorp.fuse.features.api.TrimbleAdapter.parser
import groovy.json.*
/**
 * Created by cjames on 8/15/15.
 */
class NcbiSubmitResponseXmlParser {
    def parse(fileName) {

        def submitStatuses    =   new XmlSlurper().parseText( new File(fileName).getText())
        def status = submitStatuses.@status
        def indx =0
        def study
        def submissionStatus = new SubmissionStatus(status:status)
        def actionList =[]
        def actionObject
        submitStatuses.children().each { action ->
             study =  (indx == 0) ?  action.Response.Object.Meta.SRAStudy : ""
             actionObject = new SubmitAction(action.Response.@status,action.Response.Object.@accession)
             submissionStatus.actions  << actionObject
        }
        submissionStatus.study = study
        println submissionStatus
     }

    static main(String[]  args ) {
      def parser =   new NcbiSubmitResponseXmlParser().parse("successful_report.xml")

    }


}
