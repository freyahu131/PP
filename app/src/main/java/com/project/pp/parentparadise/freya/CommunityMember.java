package com.project.pp.parentparadise.freya;

/**
 * Created by mac on 2017/12/14.
 */



    public class CommunityMember { // VO- Value Object

        private int image;
        private String name;

        public CommunityMember() {
            super();
        }

        public CommunityMember(int image, String name) {
            super();
            this.image = image;
            this.name = name;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
