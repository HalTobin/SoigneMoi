package feature.visitor_list.presentation

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import data.model.*
import ui.Screen
import ui.theme.SoigneMoiTheme
import ui.util.rememberNavController
import java.util.*

@Preview
@Composable
fun VisitorListPreview() = SoigneMoiTheme {
    val navController by rememberNavController(startDestination = Screen.EntryList.route)
    VisitorListScreen(
        navController = navController,
        state = VisitorListState(patients = DummyState.dummyPatientList, patientData = DummyState.dummyData),
        onEvent = {}
    )
}

object DummyState {
    val dummyPatientList = listOf(
        Patient(
            id = 0,
            name = "Hal",
            surname = "Tobin",
            reason = "Fatigue chronique",
            entry = true
        ),
        Patient(
            id = 1,
            name = "Alan",
            surname = "Hart",
            reason = "Insuffisance cardiaque",
            entry = false
        ),
        Patient(
            id = 2,
            name = "Marie",
            surname = "Leblanc",
            reason = "Pneumonie",
            entry = false
        ),
    )
    val dummyNotes = listOf(
        Note(
            id = 0,
            appointmentId = 0,
            doctorId = 0,
            userId = 0,
            title = "Première visite",
            content = "Le patient est très fatigué, éventuels carence, faire un examen, prescription de vitamine C et D",
            date = Date(124, 3, 24)
        ),
        Note(
            id = 1,
            appointmentId = 0,
            doctorId = 0,
            userId = 0,
            title = "Attente de résultat",
            content = "Continue le traitement actuel en attendant les résultats de la prise de sang",
            date = Date(124, 3, 25)
        ),
        Note(
            id = 2,
            appointmentId = 0,
            doctorId = 0,
            userId = 0,
            title = "Grave carence en fer",
            content = "Prescription de compléments alimentaires, revu du régime du patient",
            date = Date(124, 3, 26)
        ),
    )
    val dummyPrescriptions = listOf(
        Prescription(
            id = 0,
            appointmentId = 0,
            start = Date(124, 3, 24),
            end = Date(124, 3, 26),
            entries = listOf(
                PrescriptionEntry(
                    prescriptionId = 0,
                    dosage = 1,
                    frequency = Frequency.DAILY.id,
                    note = "1x par jour au réveil",
                    medicine = Medicine(
                        id = 0,
                        title = "Vitamine C"
                    )
                ),
                PrescriptionEntry(
                    prescriptionId = 0,
                    dosage = 1,
                    frequency = Frequency.MONTHLY.id,
                    note = "1x par mois",
                    medicine = Medicine(
                        id = 1,
                        title = "Vitamine D"
                    )
                )
            )
        ),
        Prescription(
            id = 1,
            appointmentId = 0,
            start = Date(124, 3, 26),
            end = Date(124, 3, 31),
            entries = listOf(
                PrescriptionEntry(
                    prescriptionId = 1,
                    dosage = 1,
                    frequency = Frequency.DAILY.id,
                    note = "1x par jour au réveil",
                    medicine = Medicine(
                        id = 0,
                        title = "Fer"
                    )
                )
            )
        )
    )
    val dummyData = PatientData(
        id = 0,
        name = "Hal",
        surname = "Tobin",
        mail = "hal.tobin@proton.me",
        appointment = Appointment(
            id = 0,
            visitorId = 0,
            startDate = Date(124, 3, 24),
            endDate = Date(124, 3, 31),
            reason = "Fatigue chronique",
            specialty = "Généraliste",
            doctor = "Dr. John"
        ),
        doctor = Doctor(
            id = 0,
            name = "John",
            surname = "Lejardin",
            registrationNumber = "M044568",
            specialty = Specialty(id = 0, title = "Généraliste")
        ),
        startDate = Date(124, 3, 24),
        endDate = Date(124, 3, 31),
        notes = dummyNotes,
        prescriptions = dummyPrescriptions,
        specialty = Specialty(id = 0, title = "Généraliste")
    )
    val dummyState = VisitorListState(
        patients = dummyPatientList,
        patientData = dummyData
    )
}