package com.thkoeln.hct.backend.domain.model;


import lombok.Getter;
import lombok.Setter;





public class Response {
    @Getter
    @Setter

        private String fileName;
        private String fileDownloadUri;
        private String fileType;
        private long size;

        public Response(String fileName, String fileDownloadUri, String fileType, long size) {
            this.fileName = fileName;
            this.fileDownloadUri = fileDownloadUri;
            this.fileType = fileType;
            this.size = size;
        }

}

