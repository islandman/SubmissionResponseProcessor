package com.agcocorp.fuse.features.api.TrimbleAdapter.parser

class ApiHelpers {
    //private static
    static def flatten(jsonApiData) {
        def result = [:]

        if (jsonApiData.data) {
            result.id = jsonApiData.data.id
            if (jsonApiData.data.attributes)
                result << jsonApiData.data.attributes

            if (jsonApiData.data.relationships)
                result << jsonApiData.data.relationships
        }
        return result
    }
}
