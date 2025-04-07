package lk.ijse.orm.ormhibernatefinalcw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class ProgrammeDto {
        private int id;
        private String name;
        private String duration;
        private Double fees;

        public ProgrammeDto(String name, String duration, Double fees) {
            this.name = name;
            this.duration = duration;
            this.fees = fees;
        }

        public ProgrammeDto(String name) {
            this.name = name;
        }
    }

